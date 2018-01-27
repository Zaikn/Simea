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
    private ArrayList<Solution> mDataset;

    public DictAdapter(ArrayList<Solution> myDataSet) {
        this.mDataset = myDataSet;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView Title;
        TextView infos;

        public ViewHolder(View itemView) {
            super(itemView);
            Title = itemView.findViewById(R.id.textView);
            infos = itemView.findViewById(R.id.info_text);
        }
    }


    @Override
    public DictAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v  = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(DictAdapter.ViewHolder holder, int position) {
        holder.Title.setText(mDataset.get(position).getSite());
        holder.infos.setText(mDataset.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
