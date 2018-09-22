package ca.ualberta.cs.lonelytwitter;

/**
 * Created by caochenlin on 2018/9/22.
 */

public class NormalTweet extends Tweet {

    NormalTweet() {
        super();
    }

    NormalTweet(String message) {
        super(message);
    }

    @Override
    public Boolean isImportant() {
        return false;
    }
}

