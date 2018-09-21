package ca.ualberta.cs.lonelytwitter;

/**
 * Created by chenlin on 9/20/18.
 */

import java.util.Date;

public abstract class Tweet {
    protected String message;
    protected Date date;
    public void setMessage(String message) throws TooLongTweetException {

        if (this.message.length()>140){
            throw new TooLongTweetException();
        }
        this.message = message;
    }
    public void setDate(Date date){
        this.date = date;
    }
    public String getMessage(){
        return this.message;
    }
    public Date getDate(){
        return this.date;
    }
    public abstract void isImportant();


}
