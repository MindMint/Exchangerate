package com.example.mint.data.cache;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.example.mint.data.RatePersistence;
import com.example.mint.data.remote.RateHttpModel;
import com.example.mint.exchangerate.RateApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CacheHelper {
    private ACache mCache;
    public final static String CACHE_KEY_RATES = "rates";
    public final static String CACHE_KEY_RATES_ORDER = "rates_order";
    private static CacheHelper instance;
    private RateHttpModel.Rates rates;

    public static CacheHelper getInstance() {
        if (instance == null) {
            instance = new CacheHelper();
        }
        return instance;
    }

    private CacheHelper() {
        mCache = ACache.get(RateApplication.getAppContext().getFilesDir());
    }

    public void saveRates(RateHttpModel.Rates rates) {
        this.rates = rates;
        mCache.put(CACHE_KEY_RATES, rates);
    }

    public RateHttpModel.Rates getRates() {
        if (rates == null) {
            rates = (RateHttpModel.Rates) mCache.getAsObject(CACHE_KEY_RATES);
        }
        return rates;
    }

    public class Rate {
        private final RatePersistence.EnumRate rateType;
        private final float rateValue;

        public Rate(@NonNull RatePersistence.EnumRate rateType,@NonNull float rateValue) {
            this.rateType = rateType;
            this.rateValue = rateValue;
        }

        public RatePersistence.EnumRate getRateType() {
            return rateType;
        }

        public float getRateValue() {
            return rateValue;
        }
    }

    public void saveListRateOrder(List<Rate> listRate) {
        StringBuilder sb = new StringBuilder();
        for (Rate rate : listRate) {
            sb.append(rate.getRateType()).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        mCache.put(CACHE_KEY_RATES_ORDER, sb.toString());
    }

    public List<Rate> getListRateOrder() {
        String orderStr = mCache.getAsString(CACHE_KEY_RATES_ORDER);
        List<RatePersistence.EnumRate> rateTypeList;
        if (TextUtils.isEmpty(orderStr)) {
            RatePersistence.EnumRate[] enumRates = RatePersistence.EnumRate.values();
            rateTypeList = Arrays.asList(enumRates);
        } else {
            rateTypeList = new ArrayList<>();
            String[] orderArr = orderStr.split(",");
            for (String rateName : orderArr) {
                RatePersistence.EnumRate enumRate = RatePersistence.EnumRate.valueOf(rateName);
                if (enumRate != null){
                    rateTypeList.add(enumRate);
                }
            }
        }
        List<Rate> ret = new ArrayList<>();
        for (RatePersistence.EnumRate enumRate:rateTypeList){
            Rate rate = new Rate(enumRate,getRateValue(enumRate));
            ret.add(rate);
        }
        return ret;
    }

    public float getRateValue(RatePersistence.EnumRate enumRate) {
        if(getRates() == null){
            return 0;
        }
        float ret;
        switch (enumRate) {
            case AUD:
                ret = getRates().getAUD();
                break;
            case BGN:
                ret = getRates().getBGN();
                break;
            case BRL:
                ret = getRates().getBRL();
                break;
            case CAD:
                ret = getRates().getCAD();
                break;
            case CHF:
                ret = getRates().getCHF();
                break;
            case CNY:
                ret = getRates().getCNY();
                break;
            case CZK:
                ret = getRates().getCZK();
                break;
            case DKK:
                ret = getRates().getDKK();
                break;
            case GBP:
                ret = getRates().getGBP();
                break;
            case HKD:
                ret = getRates().getHKD();
                break;
            case HRK:
                ret = getRates().getHRK();
                break;
            case HUF:
                ret = getRates().getHUF();
                break;
            case IDR:
                ret = getRates().getIDR();
                break;
            case ILS:
                ret = getRates().getILS();
                break;
            case INR:
                ret = getRates().getINR();
                break;
            case ISK:
                ret = getRates().getISK();
                break;
            case JPY:
                ret = getRates().getJPY();
                break;
            case KRW:
                ret = getRates().getKRW();
                break;
            case MXN:
                ret = getRates().getMXN();
                break;
            case MYR:
                ret = getRates().getMYR();
                break;
            case NOK:
                ret = getRates().getNOK();
                break;
            case NZD:
                ret = getRates().getNZD();
                break;
            case PHP:
                ret = getRates().getPHP();
                break;
            case PLN:
                ret = getRates().getPLN();
                break;
            case RON:
                ret = getRates().getRON();
                break;
            case RUB:
                ret = getRates().getRUB();
                break;
            case SEK:
                ret = getRates().getSEK();
                break;
            case SGD:
                ret = getRates().getSGD();
                break;
            case THB:
                ret = getRates().getTHB();
                break;
            case TRY:
                ret = getRates().getTRY();
                break;
            case USD:
                ret = getRates().getUSD();
                break;
            case ZAR:
                ret = getRates().getZAR();
                break;
            case EUR:
                ret = getRates().getEUR();
                break;
            default:
                ret = 0;
                break;
        }
        return ret;
    }
}
