package com.example.icwc.volunteerapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Results extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        String response = "";
        if (getIntent().hasExtra("response")){
            response = getIntent().getExtras().getString("response");
        }

        String interest = "";
        String target = "";
        String duration = "";

        switch (response.charAt(0)){
            case 'A':
                interest = "Social-Work";
                break;
            case 'B':
                interest = "Education";
                break;
            case 'C':
                interest = "Art";
                break;
            case 'D':
                interest = "Environment";
                break;
        }
        switch (response.charAt(1)) {
            case 'A':
                target = "Kids";
                break;
            case 'B':
                target = "Poverty";
                break;
            case 'C':
                target = "Community";
                break;
            case 'D':
                target = "Environment";
                break;
        }
        switch (response.charAt(2)) {
            case 'A':
                duration = "Day";
                break;
            case 'B':
                duration = "Weekend";
                break;
            case 'C':
                duration = "On-Going";
                break;
            case 'D':
                duration = "Trip";
                break;
        }

        ArrayList<Organization> listOfOrganizations = new ArrayList<>();
        String fileName= "raw/organizations.txt";

        try {

//            BufferedReader file = new BufferedReader(new FileReader("organizations.txt"));
            BufferedReader file = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.organizations)));
            String line = file.readLine();
            while (line != null) {
                String name = file.readLine();
                String interest1 = file.readLine();
                String target1 = file.readLine();
                String duration1 = file.readLine();
                Organization organization = new Organization(name, interest1, target1, duration1);
                listOfOrganizations.add(organization);
                line = file.readLine();
            }
        }
        catch(IOException ex){
            Log.e("~~", ex.getMessage());
            System.out.println(ex.toString());
            System.out.println("Could not find file "+fileName);
        }

        Log.e("~~~~~~~~~~~", listOfOrganizations + "");

        for (int n = 0; n <listOfOrganizations.size(); n++) {
            if (interest.equals(listOfOrganizations.get(n).getInterest())) {
                listOfOrganizations.get(n).addMatch();
                listOfOrganizations.get(n).checkMatch();
            }
        }

        for (int n=0; n<listOfOrganizations.size(); n++) {

            if (target.equals(listOfOrganizations.get(n).getTarget())) {

                listOfOrganizations.get(n).addMatch();
                listOfOrganizations.get(n).checkMatch();
            }
        }

        for (int n=0; n<listOfOrganizations.size(); n++) {
            if (duration.equals(listOfOrganizations.get(n).getDuration())) {
                listOfOrganizations.get(n).addMatch();
                listOfOrganizations.get(n).checkMatch();
            }
        }

        ArrayList<String> match100=new ArrayList<>();
        ArrayList<String> match66=new ArrayList<>();
        ArrayList<String> match33=new ArrayList<>();

        for (int n=0; n<listOfOrganizations.size(); n++){
            if (listOfOrganizations.get(n).getMatch()==100){
                match100.add(listOfOrganizations.get(n).getName());
                listOfOrganizations.get(n).resetMatch();
            }
            if (listOfOrganizations.get(n).getMatch()==66){
                match66.add(listOfOrganizations.get(n).getName());
                listOfOrganizations.get(n).resetMatch();
            }
            if (listOfOrganizations.get(n).getMatch()==33){
                match33.add(listOfOrganizations.get(n).getName());
                listOfOrganizations.get(n).resetMatch();
            }
        }


//        TextView tv1 = (TextView) findViewById(R.id.textView1);
//        TextView tv2 = (TextView) findViewById(R.id.textView2);
//        TextView tv3 = (TextView) findViewById(R.id.textView3);

        String match1;
        String match2;
        String match3;

        if (match100.size()==3) {
            match1 = match100.get(0);
            match2 = match100.get(1);
            match3 = match100.get(2);
        }

        else if (match100.size()==2) {
            match1 = match100.get(0);
            match2 = match100.get(1);
            if(match66.size()==1){
                match3 = match66.get(0);
            }
            else {
                match3 = match33.get(0);
            }
        }

        else if (match100.size()==1){
            match1 = match100.get(0);
            if(match66.size()==2){
                match2 = match66.get(0);
                match3 = match66.get(1);
            }
            else if(match66.size()==1){
                match2 = match66.get(0);
                match3 = match33.get(0);
            }
            else{
                match2 = match33.get(0);
                match3 = match33.get(1);
            }
        }

        else {
            if(match66.size()==3){
                match1 = match66.get(0);
                match2 = match66.get(1);
                match3 = match66.get(2);
            }
            else if(match66.size()==2){
                match1 = match66.get(0);
                match2 = match66.get(1);
                match3 = match33.get(0);
            }
            else if(match66.size()==1){
                match1 = match66.get(0);
                match2 = match33.get(0);
                match3 = match33.get(1);
            }

            else{
                match1 = match33.get(0);
                match2 = match33.get(1);
                match3 = match33.get(2);

            }

        }

        ArrayList<String> results = new ArrayList<>();
        results.add(match1);
        results.add(match2);
        results.add(match3);


        ImageButton res1 = (ImageButton) findViewById(R.id.imageButton1);
        ImageButton res2 = (ImageButton) findViewById(R.id.imageButton2);
        ImageButton res3 = (ImageButton) findViewById(R.id.imageButton3);

        ArrayList<ImageButton> buttons = new ArrayList<>();
        buttons.add(res1);
        buttons.add(res2);
        buttons.add(res3);

//        String url1 = "";
//        String url2 = "";
//        String url3 = "";
//        ArrayList<String> websites = new ArrayList<>();
//        results.add(url1);
//        results.add(url2);
//        results.add(url3);

        for (int n = 0; n < results.size(); n++) {
            if (results.get(n).equals("- Fall alternative break")) {
                buttons.get(n).setImageDrawable(getResources().getDrawable(R.drawable.afb));
                //websites.set(n, "");
            }
            else if (results.get(n).equals("- Spring alternative break")) {
                buttons.get(n).setImageDrawable(getResources().getDrawable(R.drawable.alternativespringbreak));
                //websites.set(n, "");
            }
            else if (results.get(n).equals("- Summer alternative break")) {
                buttons.get(n).setImageDrawable(getResources().getDrawable(R.drawable.alternativesummerbreak));
                //websites.set(n, "");
            }
            else if (results.get(n).equals("- Cayuga Nature center")) {
                buttons.get(n).setImageDrawable(getResources().getDrawable(R.drawable.cayuganature));
                //websites.set(n, "");
            }
            else if (results.get(n).equals("- Museum of Earth")) {
                buttons.get(n).setImageDrawable(getResources().getDrawable(R.drawable.museumoftheearth));
                //websites.set(n, "");
            }
            else if (results.get(n).equals("- Tompkins County Library")) {
                buttons.get(n).setImageDrawable(getResources().getDrawable(R.drawable.library));
                //websites.set(n, "");
            }
            else if (results.get(n).equals("- Sciencenter")) {
                buttons.get(n).setImageDrawable(getResources().getDrawable(R.drawable.sciencecenter));
                //websites.set(n, "");
            }
            else if (results.get(n).equals("- Wood's Earth")) {
                buttons.get(n).setImageDrawable(getResources().getDrawable(R.drawable.woodsearth));
                //websites.set(n, "");
            }
            else if (results.get(n).equals("- Big brother and big sister")) {
                buttons.get(n).setImageDrawable(getResources().getDrawable(R.drawable.bigbrotherbigsister));
                //websites.set(n, "");
            }
            else if (results.get(n).equals("- Community building works")) {
                buttons.get(n).setImageDrawable(getResources().getDrawable(R.drawable.communitybuildingworks));
                //websites.set(n, "");
            }
            else if (results.get(n).equals("- 2-1-1 Tompkins")) {
                buttons.get(n).setImageDrawable(getResources().getDrawable(R.drawable.tompkins));
                //websites.set(n, "");
            }
            else if (results.get(n).equals("- IC Red Cross")) {
                buttons.get(n).setImageDrawable(getResources().getDrawable(R.drawable.redcross));
                //websites.set(n, "");
            }
            else if (results.get(n).equals("- Ithaca Underground")) {
                buttons.get(n).setImageDrawable(getResources().getDrawable(R.drawable.ithacaunderground));
                //websites.set(n, "");
            }
            else if (results.get(n).equals("- Cayuga Nature center")) {
                buttons.get(n).setImageDrawable(getResources().getDrawable(R.drawable.cayuganature));
                //websites.set(n, "");
            }
            else if (results.get(n).equals("- Johnson Museum of Art")) {
                buttons.get(n).setImageDrawable(getResources().getDrawable(R.drawable.johnsonmuseumart));
                //websites.set(n, "");
            }
            else if (results.get(n).equals("- Handwerker Gallery")) {
                buttons.get(n).setImageDrawable(getResources().getDrawable(R.drawable.handwerkergallery));
                //websites.set(n, "");
            }

        }

//        for(int n = 0; n < results.size(); n++) {
//            buttons.get(n).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Uri address = Uri.parse();
//                }
//            });
//        }


        ImageButton newSearch = (ImageButton) findViewById(R.id.imageButton4);
        newSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent restart = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(restart);
            }
        });




    }


}
