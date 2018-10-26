package ca.ualberta.cs.lonelytwitter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by caochenlin on 2018/9/21.
 */

public abstract class CurrentMood extends Mood {

    public Mood myCurrentMood;

    public abstract void setCurrentMood(Mood mood_value);

    public abstract void getCurrentMood();
}

