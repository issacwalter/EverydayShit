package com.example.shit.everydayshit;

import android.graphics.Typeface;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {
    private FragmentTabHost mTabHost;
    private LayoutInflater inflater;
    private Class fragmentArray[] = {Fragment1HomePage.class,Fragment2HomePage.class,Fragment3HomePage.class,Fragment4HomePage.class,Fragment5HomePage.class};
    private int mImageViewArray[] = {R.drawable.leftmost,R.drawable.left,R.drawable.center,R.drawable.right,R.drawable.rightmost};
    private String mTextviewArray[] = {"首页","手纸","记录","数据","我的"};
    private TextView title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        typeFace =Typeface.createFromAsset(getAssets(),"fonts/chinesefont.ttf");
        title = (TextView)findViewById(R.id.title_text);
        setFragmentIndicator();
        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                title.setText(tabId);
            }
        });
    }

    private void setFragmentIndicator(){
        inflater = LayoutInflater.from(this);
        mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup(this,getSupportFragmentManager(),R.id.realtabcontent);

        int count = fragmentArray.length;
        for(int i = 0 ;i < count;i++){
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(mTextviewArray[i]).setIndicator(getTabItemView(i));
            mTabHost.addTab(tabSpec,fragmentArray[i],null);
            //set backgroud of buttons;
            //mTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.units);
        }
    }

    private View getTabItemView(int index){
        View view = inflater.inflate(R.layout.tabs,null);
        ImageView imageView = (ImageView)view.findViewById(R.id.everyicon);
        imageView.setImageResource(mImageViewArray[index]);

        TextView textView = (TextView)view.findViewById(R.id.everyitem);
        textView.setText(mTextviewArray[index]);
//        textView.setTypeface(typeFace);
        return view;
    }
}
