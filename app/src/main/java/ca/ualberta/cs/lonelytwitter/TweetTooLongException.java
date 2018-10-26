package ca.ualberta.cs.lonelytwitter;

/**
 * Created by caochenlin on 2018/9/22.
 */

public class TweetTooLongException extends Exception {
    TweetTooLongException() {
        super("The message is too long! Please keep your tweets within 140 characters.");
    }
}
