package ca.ualberta.cs.lonelytwitter;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public abstract class Mood {



    public Date date;

    public abstract Date getDate();

    public abstract void setDate(Date date_value);

    public abstract String express();
}

class Happy extends Mood {



    public Date getDate(){
        return date;
    }

    public void setDate(Date date_value) {
        this.date = date_value;
    }

    public Happy() {
        this.date = new java.util.Date();
    }

    public String express() {
        String happiness = "happy!";
        //System.out.println(happiness);
        return happiness;
    }

}

class Sad extends Mood {

    public Date getDate() {
        return date;
    }

    public void setDate(Date date_value) {
        this.date = date_value;
    }

    public Sad() {
        this.date = new java.util.Date();
    }

    public String express() {
        String sadness = "sad!";
        //System.out.println(sadness);
        return sadness;
    }
}

class Angry extends Mood{

    public Date getDate() {
        return date;
    }

    public void setDate(Date date_value){
        this.date = date_value;
    }

    public Angry(){
        this.date = new java.util.Date();
    }

    public Angry(Date myDate){
        this.date = myDate;

    }

    public String express(){
        String anger = "angry!";
        //System.out.println(anger);
        return anger;
    }

}

class Thrilled extends Mood{

    public Date getDate(){
        return date;
    }

    public void setDate(Date date_value){
        this.date = date_value;
    }

    public Thrilled(){
        this.date = new java.util.Date();
    }

    public Thrilled(Date myDate){
        this.date = myDate;
    }

    public String express(){
        String thrill = "thrilled!";
        //System.out.println(thrill);
        return thrill;
    }
}