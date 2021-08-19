package com.example.fragmentinterview;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class ListFragment extends androidx.fragment.app.ListFragment {

    private onItemListener onItemListener;


//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_list, container, false);
//    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        setListAdapter(new ArrayAdapter<<String>(this.getActivity(), android.R.layout.simple_list_item_1),
//                getResources().getStringArray(R.array.name));

        setListAdapter(new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.name)));
    }

    public interface onItemListener {
        public void onItemClickListener(int index);
    }



    @Override
    public void onAttach(@NonNull  Context context) {
        super.onAttach(context);
        try{
            onItemListener = (onItemListener) context;
        }
        catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement the interface");
        }
    }

    @Override
    public void onListItemClick(@NonNull  ListView l, @NonNull  View v, int position, long id) {
        onItemListener.onItemClickListener(position);
    }
}