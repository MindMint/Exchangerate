package com.example.mint.exchangerate;


import com.example.mint.data.cache.CacheHelper;
import com.example.mint.data.remote.RateHttpModel;
import com.example.mint.data.remote.RetrofitHelper;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * Created by mint on 2018/4/12.
 */

public class ParsePresenter implements MainContract.IParsePresenter {
    private MainContract.IMainView mainView;

    public ParsePresenter(MainContract.IMainView mainView) {
        this.mainView = mainView;
    }

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    public void getRates() {
        if(CacheHelper.getInstance().getRates() == null){
            updateRates();
        }else {
            List<CacheHelper.Rate> rateList = CacheHelper.getInstance().getListRateOrder();
            mainView.getRatesSuccess(rateList);
        }
    }

    @Override
    public void updateRates() {
        mainView.showProgress();
        RetrofitHelper.getInstance().listRates().subscribe(new Consumer<RateHttpModel>() {
            @Override
            public void accept(RateHttpModel rateHttpModel) throws Exception {
                CacheHelper.getInstance().saveRates(rateHttpModel.getRates());
                getRates();
                mainView.updateRateSuccess();
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                mainView.updateRateFailed();
                mainView.hideProgress();
            }
        }, new Action() {
            @Override
            public void run() throws Exception {
                mainView.hideProgress();
            }
        });
    }

    @Override
    public void unsubscribe() {
        compositeDisposable.dispose();
    }
}
