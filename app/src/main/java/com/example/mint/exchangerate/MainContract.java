package com.example.mint.exchangerate;

import com.example.mint.data.cache.CacheHelper;

import java.util.List;

/**
 * Created by mint on 2018/4/16.
 */

public class MainContract {
    public interface IMainView {
        void showProgress();
        void hideProgress();
        void updateRateSuccess();
        void updateRateFailed();
        void getRatesSuccess(List<CacheHelper.Rate> rateList);
        void getRatesFailed();
    }

    public interface IParsePresenter {
        void getRates();
        void updateRates();
        void unsubscribe();
    }
}
