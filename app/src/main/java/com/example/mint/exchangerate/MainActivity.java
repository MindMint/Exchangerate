package com.example.mint.exchangerate;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mint.data.cache.CacheHelper;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,MainContract.IMainView{
    private Toolbar toolbar;
    private TextView btnRefresh;
    private RecyclerView ratesList;
    private ListRatesAdapter adapter;
    private ProgressDialog progressDialog;
    private MainContract.IParsePresenter parsePresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        btnRefresh = findViewById(R.id.btn_refresh);
        btnRefresh.setOnClickListener(this);

        ratesList = findViewById(R.id.rates_list);
        ratesList.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        adapter = new ListRatesAdapter();
        ratesList.setAdapter(adapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SimpleItemTouchHelperCallback(adapter));
        itemTouchHelper.attachToRecyclerView(ratesList);

        parsePresenter = new ParsePresenter(this);
        parsePresenter.getRates();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        parsePresenter.unsubscribe();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_refresh:
                parsePresenter.updateRates();
                break;
            default:
                break;
        }
    }

    @Override
    public void showProgress() {
        if(progressDialog == null){
            progressDialog = new ProgressDialog(this);
        }
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        if(progressDialog != null && progressDialog.isShowing()){
            progressDialog.dismiss();
        }
    }

    @Override
    public void updateRateSuccess() {
        Toast.makeText(this,"更新汇率成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateRateFailed() {
        Toast.makeText(this,"更新汇率失败",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getRatesSuccess(List<CacheHelper.Rate> rateList) {
        adapter.setData(rateList);
    }

    @Override
    public void getRatesFailed() {
        Toast.makeText(this,"需要请求网络获取汇率",Toast.LENGTH_SHORT).show();
    }
}
