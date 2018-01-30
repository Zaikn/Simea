package com.example.simea.simea;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.simea.simea.MissionFragment.OnListFragmentInteractionListener;

import java.util.List;

/**
 *
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyMissionRecyclerViewAdapter extends RecyclerView.Adapter<MyMissionRecyclerViewAdapter.ViewHolder> {

    private final List<Mission> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyMissionRecyclerViewAdapter(List<Mission> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_mission, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.id.setText(mValues.get(position).toString());
        holder.description.setText(mValues.get(position).toString());

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
        public final TextView id;
        public final TextView description;
        public final TextView Site;
        public Mission mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            id =  view.findViewById(R.id.idMission);
            description =  view.findViewById(R.id.missionDescription);
            Site = view.findViewById(R.id.Site);
        }

        @Override
        public String toString() {
            return super.toString() + " '"  + "'";
        }
    }
}
