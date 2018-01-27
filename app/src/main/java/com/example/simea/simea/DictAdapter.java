package com.example.simea.simea;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by youness on 26/01/2018.
 */

class DictAdapter extends RecyclerView.Adapter<DictAdapter.ViewHolder>{

    private Context mContext;
    private ArrayList<String> mDataset;

    public DictAdapter(ArrayList<String> myDataSet) {
        this.mDataset = myDataSet;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;

        public ViewHolder(TextView itemView) {
            super(itemView);
            mTextView = itemView;
        }
    }


    @Override
    public DictAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView v  = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(DictAdapter.ViewHolder holder, int position) {
        holder.mTextView.setText(mDataset.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
