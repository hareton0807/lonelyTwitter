
/*
 * Class name: LonelyTwitterActivity
 *
 * Class version: 1.0
 *
 * Date: October 4,2018
 *
 * Copyright (c) Team X, CMPUT301, University of Alberta - All Rights Reserved. You may use, distribute, or modify this code under terms and conditions of the Code of Students Behavior at University of Alberta
 */

package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


/**
 * The type Lonely twitter activity.
 */
public class LonelyTwitterActivity extends Activity {

    private static final String FILENAME = "file2.sav";
    private EditText bodyText;
    private ListView oldTweetsList;

    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    private ArrayAdapter<Tweet> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        bodyText = (EditText) findViewById(R.id.body);
        Button saveButton = (Button) findViewById(R.id.save);
        oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);


        saveButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                String text = bodyText.getText().toString();
                ImportantTweet newTweet = new ImportantTweet();
                try {
                    newTweet.setMessage(text);
                    newTweet.setDate(new Date());
                    tweets.add(newTweet);
                    saveInFile();
                    adapter.notifyDataSetChanged();
                }catch(TooLongTweetException e){

                }
            }
        });
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        loadFromFile();
        adapter = new ArrayAdapter<Tweet>(this, R.layout.list_item, tweets);
        oldTweetsList.setAdapter(adapter);
    }

    private void loadFromFile() {

        try {
            FileInputStream fis = openFileInput(FILENAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader reader = new BufferedReader(isr);

            Gson gson = new Gson();
            Type listTweetType = new TypeToken<ArrayList<ImportantTweet>>(){}.getType();

            tweets = gson.fromJson(reader,listTweetType);


        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            tweets = new ArrayList<Tweet>();
            e.printStackTrace();
        }

    }

    private void saveInFile() {
        try {

            FileOutputStream fos = openFileOutput(FILENAME,0);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter writer = new BufferedWriter(osw);
            Gson gson = new Gson();
            gson.toJson(tweets,writer);
            writer.flush();
            fos.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}