package com.example.simea.simea;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.simea.simea.TravauxFragment.OnListFragmentInteractionListener;
import com.example.simea.simea.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyTravauxRecyclerViewAdapter extends RecyclerView.Adapter<MyTravauxRecyclerViewAdapter.ViewHolder> {

    private final List<Travaux> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyTravauxRecyclerViewAdapter(List<Travaux> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_travaux, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mAction.setSelection(mValues.get(position).getAction());
        holder.mFurniture.setSelection(mValues.get(position).getFourniture());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final Spinner mAction;
        public final Spinner mFurniture;
        public Travaux mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mAction =  view.findViewById(R.id.action);
            mFurniture = view.findViewById(R.id.furniture);
        }

        @Override
        public String toString() {
            return super.toString() + " '"  + "'";
        }
    }
}
