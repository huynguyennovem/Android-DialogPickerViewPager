package com.template.dialogpicker;


import android.os.Bundle;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class DateFragment extends Fragment {

    StringBuilder mDate;

    public DateFragment() {
        // Required empty public constructor
    }

    public static DateFragment newInstance() {
        DateFragment fragment = new DateFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDate = new StringBuilder();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_date, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final DatePicker datePicker = view.findViewById(R.id.datePicker);

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        Date date = new Date();
        String format = "dd/MM/yyyy";
        final SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.getDefault());
        mDate.append(formatter.format(date));
        Calendar c2 = Calendar.getInstance();
        c2.set(2017, 0, 1);//Year,Mounth -1,Day
        datePicker.setMaxDate(c2.getTimeInMillis());
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int y, int m, int dayOfMonth) {
                c.set(y, m, dayOfMonth);
                mDate = new StringBuilder();
                mDate.append(formatter.format(c.getTime()));
            }
        });
    }

    public String getSelectedDate() {
        return mDate.toString();
    }
}
