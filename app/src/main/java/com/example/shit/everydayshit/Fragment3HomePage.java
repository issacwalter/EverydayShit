package com.example.shit.everydayshit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ExpandableListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by He on 2016/4/12.
 */
public class Fragment3HomePage extends Fragment implements ExpandableListView.OnGroupExpandListener,CompoundButton.OnCheckedChangeListener {
    View view;
    ExpandableListView expandableListView;
    MyExpandableAdapter myExpandableAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragmentlayout_middle, container, false);
        expandableListView = (ExpandableListView) view.findViewById(R.id.expandable_listview);
        myExpandableAdapter = new MyExpandableAdapter(getContext());
        expandableListView.setGroupIndicator(null);
        expandableListView.setOnGroupExpandListener(this);
        expandableListView.setAdapter(myExpandableAdapter);

//        expandableListView.setDivider(null);
        return view;
    }

    @Override
    public void onGroupExpand(int groupPosition) {
        int len = myExpandableAdapter.getGroupCount();

        for (int i = 0; i < len; i++) {
            if (i != groupPosition) {
                expandableListView.collapseGroup(i);
            }
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
    }
}
