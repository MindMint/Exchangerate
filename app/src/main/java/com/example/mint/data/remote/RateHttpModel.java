package com.example.mint.data.remote;

import java.io.Serializable;

/**
 * Created by mint on 2018/4/16.
 */

public class RateHttpModel {
    private String base;
    private String date;
    private Rates rates;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Rates getRates() {
        return rates;
    }

    public void setRates(Rates rates) {
        this.rates = rates;
    }

    public class Rates implements Serializable{
        private float AUD;
        private float BGN;
        private float BRL;
        private float CAD;
        private float CHF;
        private float CNY;
        private float CZK;
        private float DKK;
        private float GBP;
        private float HKD;
        private float HRK;
        private float HUF;
        private float IDR;
        private float ILS;
        private float INR;
        private float ISK;
        private float JPY;
        private float KRW;
        private float MXN;
        private float MYR;
        private float NOK;
        private float NZD;
        private float PHP;
        private float PLN;
        private float RON;
        private float RUB;
        private float SEK;
        private float SGD;
        private float THB;
        private float TRY;
        private float USD;
        private float ZAR;
        //base
        private final float EUR = 1;

        public float getAUD() {
            return AUD;
        }

        public void setAUD(float AUD) {
            this.AUD = AUD;
        }

        public float getBGN() {
            return BGN;
        }

        public void setBGN(float BGN) {
            this.BGN = BGN;
        }

        public float getBRL() {
            return BRL;
        }

        public void setBRL(float BRL) {
            this.BRL = BRL;
        }

        public float getCAD() {
            return CAD;
        }

        public void setCAD(float CAD) {
            this.CAD = CAD;
        }

        public float getCHF() {
            return CHF;
        }

        public void setCHF(float CHF) {
            this.CHF = CHF;
        }

        public float getCNY() {
            return CNY;
        }

        public void setCNY(float CNY) {
            this.CNY = CNY;
        }

        public float getCZK() {
            return CZK;
        }

        public void setCZK(float CZK) {
            this.CZK = CZK;
        }

        public float getDKK() {
            return DKK;
        }

        public void setDKK(float DKK) {
            this.DKK = DKK;
        }

        public float getGBP() {
            return GBP;
        }

        public void setGBP(float GBP) {
            this.GBP = GBP;
        }

        public float getHKD() {
            return HKD;
        }

        public void setHKD(float HKD) {
            this.HKD = HKD;
        }

        public float getHRK() {
            return HRK;
        }

        public void setHRK(float HRK) {
            this.HRK = HRK;
        }

        public float getHUF() {
            return HUF;
        }

        public void setHUF(float HUF) {
            this.HUF = HUF;
        }

        public float getIDR() {
            return IDR;
        }

        public void setIDR(float IDR) {
            this.IDR = IDR;
        }

        public float getILS() {
            return ILS;
        }

        public void setILS(float ILS) {
            this.ILS = ILS;
        }

        public float getINR() {
            return INR;
        }

        public void setINR(float INR) {
            this.INR = INR;
        }

        public float getISK() {
            return ISK;
        }

        public void setISK(float ISK) {
            this.ISK = ISK;
        }

        public float getJPY() {
            return JPY;
        }

        public void setJPY(float JPY) {
            this.JPY = JPY;
        }

        public float getKRW() {
            return KRW;
        }

        public void setKRW(float KRW) {
            this.KRW = KRW;
        }

        public float getMXN() {
            return MXN;
        }

        public void setMXN(float MXN) {
            this.MXN = MXN;
        }

        public float getMYR() {
            return MYR;
        }

        public void setMYR(float MYR) {
            this.MYR = MYR;
        }

        public float getNOK() {
            return NOK;
        }

        public void setNOK(float NOK) {
            this.NOK = NOK;
        }

        public float getNZD() {
            return NZD;
        }

        public void setNZD(float NZD) {
            this.NZD = NZD;
        }

        public float getPHP() {
            return PHP;
        }

        public void setPHP(float PHP) {
            this.PHP = PHP;
        }

        public float getPLN() {
            return PLN;
        }

        public void setPLN(float PLN) {
            this.PLN = PLN;
        }

        public float getRON() {
            return RON;
        }

        public void setRON(float RON) {
            this.RON = RON;
        }

        public float getRUB() {
            return RUB;
        }

        public void setRUB(float RUB) {
            this.RUB = RUB;
        }

        public float getSEK() {
            return SEK;
        }

        public void setSEK(float SEK) {
            this.SEK = SEK;
        }

        public float getSGD() {
            return SGD;
        }

        public void setSGD(float SGD) {
            this.SGD = SGD;
        }

        public float getTHB() {
            return THB;
        }

        public void setTHB(float THB) {
            this.THB = THB;
        }

        public float getTRY() {
            return TRY;
        }

        public void setTRY(float TRY) {
            this.TRY = TRY;
        }

        public float getUSD() {
            return USD;
        }

        public void setUSD(float USD) {
            this.USD = USD;
        }

        public float getZAR() {
            return ZAR;
        }

        public void setZAR(float ZAR) {
            this.ZAR = ZAR;
        }

        public float getEUR() {
            return EUR;
        }
    }
}
