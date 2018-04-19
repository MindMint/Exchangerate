package com.example.mint.data.remote;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mint on 2018/4/16.
 */

public class RetrofitHelper {
    private Retrofit retrofit;
    private static RetrofitHelper instance;
    public static RetrofitHelper getInstance(){
        if(instance == null){
            instance = new RetrofitHelper();
        }
        return instance;
    }
    private RetrofitHelper(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.fixer.io")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public Flowable<RateHttpModel> listRates(){
        RateService rateService = retrofit.create(RateService.class);
        return rateService.listRates().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
