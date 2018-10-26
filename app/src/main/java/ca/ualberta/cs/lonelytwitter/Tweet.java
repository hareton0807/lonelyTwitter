package ca.ualberta.cs.lonelytwitter;

/**
 * Created by caochenlin on 2018/9/22.
 */

import java.lang.reflect.Array;
import java.util.Date;
import java.util.ArrayList;

public abstract class Tweet {
    private Date date;
    private String message;
    private static final Integer MAX_CHARS = 140;

    // Store a list of moods
    private ArrayList<Mood> moodArrayList = new ArrayList<Mood>();


    //Empty argument constructor with default values
    Tweet() {
        //Must use the 'this' keyword in order to specify the current object message = message does nothing!
        this.date = new Date();
        this.message = "I am default message schwa!";
    }

    //Overloading: so that we can specify the tweet content
    Tweet(String message) {
        this.date = new Date();
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() <= this.MAX_CHARS ) {
            this.message = message;
        } else {
            throw new TweetTooLongException();
        }
    }

    public Date getDate() { return this.date; }

    //No method body implemented! We leave that up to the subclasses (they MUST implement it)
    public abstract Boolean isImportant();

    //Add a way for each tweet to have a list of moods
    public void setMoods(Mood mood_value){
        if (mood_value != null) {

            this.moodArrayList.add(mood_value);
        }
    }

    public String getMoods(){
        String myMoods = "";
        for (int i=0;i<moodArrayList.size();i++){
            myMoods += this.moodArrayList.get(i).express()+ " ";
        }
        return myMoods;
    }
}
