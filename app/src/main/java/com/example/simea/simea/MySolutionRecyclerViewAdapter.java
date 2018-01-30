package com.example.simea.simea;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.simea.simea.DictionnaryFragment.OnListFragmentInteractionListener;

import java.util.List;


public class MySolutionRecyclerViewAdapter extends RecyclerView.Adapter<MySolutionRecyclerViewAdapter.ViewHolder> {

    private final List<Solution> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MySolutionRecyclerViewAdapter(List<Solution> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_solution, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.name.setText(mValues.get(position).getSite());
        holder.description.setText(mValues.get(position).getDescription());
        holder.id.setText(mValues.get(position).getAppareil());

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
        public final TextView name;
        public Solution mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            id = (TextView) view.findViewById(R.id.id);
            description = (TextView) view.findViewById(R.id.Description);
            name = (TextView) view.findViewById(R.id.Name);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + description.getText() + "'";
        }
    }
}
