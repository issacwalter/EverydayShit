package com.example.shit.everydayshit;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by He on 2016/4/15.
 */
public class MyExpandableAdapter extends BaseExpandableListAdapter implements View.OnClickListener {
    public static final String TAG = "TTEST";
    public static int[] selectedButton = new int[8];
    private List<String> parentItem;
    private Map<String, List<String>> parentMap;
    private Map<String, List<String>> childMap;
    private Context mContext;
    private RadioButton radioButton1, radioButton2, radioButton3, radioButton4, radioButton5, button;
    private TextView textView;
    private Map<Integer, View>[] arrayMap = new HashMap[8];


    public MyExpandableAdapter(Context mContext) {
        this.mContext = mContext;
        init();

    }

    void init() {
        for (int i = 0; i < arrayMap.length; i++) {
            arrayMap[i] = new HashMap<>();
        }

        parentItem = new ArrayList<String>();
        parentItem.add("排便时间");
        parentItem.add("排便耗时");
        parentItem.add("排便姿势");
        parentItem.add("便便颜色");
        parentItem.add("便便形状");
        parentItem.add("便便气味");
        parentItem.add("便便分量");
        parentItem.add("添加手纸");

        List list1 = new ArrayList<String>() {{
            add("少于3分钟");
            add("3-5分钟");
            add("5-10分钟");
            add("10分钟以上");
        }};
        List list2 = new ArrayList<String>() {{
            add("蹲");
            add("坐");
            add("躺");
        }};
        List list3 = new ArrayList<String>() {{
            add("红");
            add("黄");
            add("黑");
        }};
        List list4 = new ArrayList<String>() {{
            add("香蕉状");
            add("烂泥状");
            add("颗粒状");
            add("水液状");
        }};
        List list5 = new ArrayList<String>() {{
            add("基本无味");
            add("有味道");
            add("恶臭");
        }};
        List list6 = new ArrayList<String>() {{
            add("稀少");
            add("较少");
            add("我的正常量");
            add("较多");
            add("非常多");
        }};

        childMap = new HashMap<String, List<String>>();
        childMap.put(parentItem.get(1), list1);
        childMap.put(parentItem.get(2), list2);
        childMap.put(parentItem.get(3), list3);
        childMap.put(parentItem.get(4), list4);
        childMap.put(parentItem.get(5), list5);
        childMap.put(parentItem.get(6), list6);


        parentMap = new HashMap<String, List<String>>();

        for (int i = 1; i < parentItem.size() - 1; i++) {
            parentMap.put(parentItem.get(i), new ArrayList<String>() {{
                add("");
            }});

        }
        parentMap.put(parentItem.get(0), new ArrayList<String>());
        parentMap.put(parentItem.get(7), new ArrayList<String>());
    }

    @Override
    public int getGroupCount() {
        return parentItem.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return parentMap.get(parentItem.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return parentItem.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return parentMap.get(parentItem.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.expanlist_parent_item, null);
        textView = (TextView) view.findViewById(R.id.parent_item);
        textView.setText(parentItem.get(groupPosition));
        if(isExpanded){

        }
        return view;
    }

    @Override
    public View getChildView(final int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final List<RadioButton> radioButtonList = new ArrayList<>(5);
        final Map<RadioButton,Integer> radioButtonMap = new HashMap<>(5);
        View view = LayoutInflater.from(mContext).inflate(R.layout.expanlist_son_item, null);
        radioButton1 = (RadioButton) view.findViewById(R.id.radio_button_1);
        radioButton2 = (RadioButton) view.findViewById(R.id.radio_button_2);
        radioButton3 = (RadioButton) view.findViewById(R.id.radio_button_3);
        radioButton4 = (RadioButton) view.findViewById(R.id.radio_button_4);
        radioButton5 = (RadioButton) view.findViewById(R.id.radio_button_5);

        radioButtonList.add(radioButton1);
        radioButtonList.add(radioButton2);
        radioButtonList.add(radioButton3);
        radioButtonList.add(radioButton4);
        radioButtonList.add(radioButton5);

        int id = radioButton1.getId();

        if (selectedButton[groupPosition] != 0) {
            Log.d(TAG, "selectedButton[groupPosition]: "+Integer.toHexString(selectedButton[groupPosition]));
            switch (selectedButton[groupPosition]){
                case 0x7f0c0084:radioButton1.setChecked(true);
                    break;
                case 0x7f0c0085:radioButton2.setChecked(true);
                    break;
                case 0x7f0c0086:radioButton3.setChecked(true);
                    break;
                case 0x7f0c0087:radioButton4.setChecked(true);
                    break;
                case 0x7f0c0088:radioButton5.setChecked(true);
                    break;
                default:break;
            }
        }

        if (groupPosition > 0 && groupPosition < 7) {
            for (int i = 0; i < radioButtonList.size(); i++) {
                try {
                    radioButtonList.get(i).setText(childMap.get(parentItem.get(groupPosition)).get(i));
                    radioButtonList.get(i).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            clearOthers(radioButtonList, groupPosition, v);
                        }
                    });
                } catch (Exception e) {
                    radioButtonList.get(i).setVisibility(View.GONE);
                }
            }
        }

        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    private void clearOthers(List<RadioButton> radioButtonList, int groupPosition, View v) {
        for(int i = 0;i<radioButtonList.size();i++){
            radioButtonList.get(i).setChecked(false);
        }
        ((RadioButton) v).setChecked(true);
        selectedButton[groupPosition] = v.getId();
        Log.d(TAG, "v.getId(): "+Integer.toHexString(v.getId()));
    }

    @Override
    public void onClick(View v) {

    }
}
