package com.example.shit.everydayshit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.format.TitleFormatter;
import com.prolificinteractive.materialcalendarview.format.WeekDayFormatter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by He on 2016/4/12.
 */
public class Fragment1HomePage extends Fragment {
    public static final String TAGS = "TTEST";
    MaterialCalendarView calendarView;
    View view;
    Button pencil,poo,home,smallcalendar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragmentlayout_homepage,container,false);
        calendarView = (MaterialCalendarView) view.findViewById(R.id.calendarView);
        initCalendarView(calendarView);

        return view;
    }


    protected void initCalendarView(MaterialCalendarView calendarView) {
        final StringBuilder sb = new StringBuilder();

        //set title in chinese form
        calendarView.setTitleFormatter(new TitleFormatter() {
            @Override
            public CharSequence format(CalendarDay day) {
                return new SimpleDateFormat(
                        "MMMM yyyy年", Locale.CHINA
                ).format(day.getDate());
            }
        });

        //set weeks in chinese form
        calendarView.setWeekDayFormatter(new WeekDayFormatter() {
            @Override
            public CharSequence format(int dayOfWeek) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.DAY_OF_WEEK, dayOfWeek);
                sb.setLength(0);
                sb.append(calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.CHINA));
                return sb.delete(0,1).toString();
            }
        });
        //calendarView.setTileSizeDp(15);
        Log.d("TTEST", "initCalendarView: "+calendarView.getTileSize());


    }







}
