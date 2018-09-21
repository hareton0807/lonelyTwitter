package ca.ualberta.cs.lonelytwitter;

/**
 * Created by chenlin on 9/20/18.
 */

import android.util.Log;

public class Cat extends Animal {

    public Cat(String type, String food){
        super(type,food);
    }

    public void swim(){
        Log.d("cmput-301","Yeah, I love to swim");

    }
}
