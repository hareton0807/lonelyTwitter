package ca.ualberta.cs.lonelytwitter;

/**
 * Created by caochenlin on 2018/9/22.
 */

public class ImportantTweet extends Tweet {

    //Empty argument constructor with default values
    ImportantTweet() {
        //Call the parent constructor to: avoid duplication!
        super();
    }

    ImportantTweet(String message) {
        super(message);
    }

    @Override
    public Boolean isImportant() {
        return true;
    }
}
