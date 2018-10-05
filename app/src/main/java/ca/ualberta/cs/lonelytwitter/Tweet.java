/*
 * Class name: Tweet
 *
 * Class version: 1.0
 *
 * Date: October 4,2018
 *
 * Copyright (c) Team X, CMPUT301, University of Alberta - All Rights Reserved. You may use, distribute, or modify this code under terms and conditions of the Code of Students Behavior at University of Alberta
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Represents a Tweet
 *
 * @author Chenlin Cao
 * @version 1.0
 * @see NormalTweet
 * @see ImportantTweet
 * @since 1.0
 */

public abstract class Tweet {
    private String message;
    private Date date;
    public Tweet(){
        this.message = "";
        this.date = new Date();
    }

    /**
     * Constructs Tweet objects
     *
     * @param message tweet message
     * @param date tweet date
     */
    public Tweet(String message,Date date){
        this.message = message;
        this.date = date;
    }



    /**
     * Sets tweet messages
     *
     * @param message Tweet message
     * @throws TooLongTweetException
     */

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
    public abstract Boolean isImportant();

    public String toString(){
        return this.date.toString()+" | "+this.message;
    }


}
