package com.example.mint.data;

/**
 * Created by mint on 2018/4/17.
 */

public class SpHelper {
    private static SpHelper instance;
    public static SpHelper getInstance(){
        if(instance == null){
            instance = new SpHelper();
        }
        return instance;
    }
    private SpHelper(){

    }
}
