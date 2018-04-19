package com.example.mint.exchangerate;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mint.data.cache.CacheHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by mint on 2018/4/16.
 */

public class ListRatesAdapter extends RecyclerView.Adapter<ListRatesAdapter.Holder> implements ItemTouchHelperAdapter {
    private final List<CacheHelper.Rate> rateList = new ArrayList<>();
    private float baseToEur = 1;

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_rate, parent, false);
        Holder holder = new Holder(itemView);
        return holder;
    }

    public void setData(List<CacheHelper.Rate> rateList) {
        this.rateList.clear();
        this.rateList.addAll(rateList);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        CacheHelper.Rate rate = rateList.get(position);
        holder.textRate.setText(rate.getRateType().toString());
        holder.editRate.setText(String.valueOf(rate.getRateValue() * baseToEur));
    }

    @Override
    public int getItemCount() {
        return rateList.size();
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(rateList, fromPosition, toPosition);
        CacheHelper.getInstance().saveListRateOrder(rateList);
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    public final class Holder extends RecyclerView.ViewHolder implements ItemTouchHelperViewHolder {
        private TextView textRate;
        private EditText editRate;

        public Holder(View itemView) {
            super(itemView);
            textRate = itemView.findViewById(R.id.text_rate);
            editRate = itemView.findViewById(R.id.edit_rate);
            editRate.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                    Log.d("zgl","beforeTextChanged");
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                    Log.d("zgl","onTextChanged");
                }

                @Override
                public void afterTextChanged(Editable editable) {
                    if (editRate.isFocused() && !TextUtils.isEmpty(editable.toString())) {
                        baseToEur = Float.valueOf(editable.toString()) / rateList.get(getAdapterPosition()).getRateValue();
                        for (int i = 0; i < getItemCount(); i++) {
                            if (i != getAdapterPosition()) {
                                notifyItemChanged(i);
                            }
                        }
                    }
                }
            });
        }

        @Override
        public void onItemSelected() {
            itemView.setBackgroundColor(Color.LTGRAY);
        }

        @Override
        public void onItemClear() {
            itemView.setBackgroundColor(0);
        }
    }
}
