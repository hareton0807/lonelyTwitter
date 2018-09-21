package ca.ualberta.cs.lonelytwitter;

/**
 * Created by chenlin on 9/20/18.
 */

import android.util.Log;

public abstract class Animal {      // YOu cannot create an instance of an abstract class
    protected String type;
    protected String food;

    public Animal(String type, String food){
        this.type = type;
        this.food = food;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFood(String food) {
        this.food = food;
    }


    public String getType(){
        return this.type;
    }

    public String getFood(){
        return this.food;
    }

    public void swim(){ // an abstract method: empty in the parent class, child classess must define by themselves
    }
}
