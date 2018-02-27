package com.example.simea.simea;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.simea.simea.dummy.DummyContent;
import com.example.simea.simea.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class TravauxFragment extends Fragment implements OnSavedListener {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    private ArrayList<Travaux> mdata = new ArrayList<>();
    private MyTravauxRecyclerViewAdapter madapter;
    private ItemTouchHelper mItemTouchHelper;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public TravauxFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static TravauxFragment newInstance(int columnCount) {
        TravauxFragment fragment = new TravauxFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_travaux_list, container, false);
        mdata.add(new Travaux(0,0));
        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            madapter = new MyTravauxRecyclerViewAdapter(mdata, mListener);
            recyclerView.setAdapter(madapter);
        }
        RecyclerView recyclerView = (RecyclerView) view;
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(madapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ItemTouchHelper.Callback callback = new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                RemoveItem(viewHolder.getAdapterPosition());
            }
        };
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(recyclerView);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public ArrayList<Travaux> onSavedButton(ArrayList<Travaux> works) {
        return this.mdata;
    }

    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Travaux item);
    }

    public void AddItem()
    {
        mdata.add(new Travaux(0,0));
        madapter.notifyItemInserted(mdata.size() - 1);
    }
    public void RemoveItem(int index)
    {
        mdata.remove(index);
        madapter.notifyItemRemoved(index);
    }

}
