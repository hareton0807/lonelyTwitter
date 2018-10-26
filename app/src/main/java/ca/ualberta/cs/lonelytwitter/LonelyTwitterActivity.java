package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.util.Log;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;


	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button addButton = (Button) findViewById(R.id.add);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		final NormalTweet myTweet = new NormalTweet();

        addButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


                final Spinner mySpinner = (Spinner) findViewById(R.id.spinner1);
                String selection = mySpinner.getSelectedItem().toString();


                if (selection.compareTo("Happy") == 0){

                    Happy myMood = new Happy();
                    myTweet.setMoods(myMood);

                }
                else if (selection.compareTo("Sad") == 0){

                    Sad myMood = new Sad();
                    myTweet.setMoods(myMood);

                }
                else if (selection.compareTo("Angry") == 0){
                    Angry myMood = new Angry();
                    myTweet.setMoods(myMood);

                }
                else{
                    Thrilled myMood = new Thrilled();
                    myTweet.setMoods(myMood);

                }

            }

        });

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {

			    String moodText = myTweet.getMoods();

                String text = bodyText.getText().toString();

                text = moodText + text;

				try{
					myTweet.setMessage(text);
				}catch(TweetTooLongException e){

				}
				saveInFile(text, new Date(System.currentTimeMillis()));


			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		String[] tweets = loadFromFile();
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

	private String[] loadFromFile() {
		ArrayList<String> tweets = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			String line = in.readLine();
			while (line != null) {
				tweets.add(line);
				line = in.readLine();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tweets.toArray(new String[tweets.size()]);
	}

	private void saveInFile(String text, Date date) {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_APPEND);
			fos.write(new String(date.toString() + " | " + text)
					.getBytes());
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