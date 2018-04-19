package com.example.mint.data.remote;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * Created by mint on 2018/4/16.
 */

public interface RateService {
    @GET("/latest")
    Flowable<RateHttpModel> listRates();
}
