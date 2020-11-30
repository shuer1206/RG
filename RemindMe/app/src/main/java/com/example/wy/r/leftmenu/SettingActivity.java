package com.example.wy.r.leftmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Calendar;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.wy.r.MainActivity;
import com.example.wy.r.R;

public class SettingActivity extends AppCompatActivity {

    //显示时间信息
    private TextView tvTimePickerDisplay;
    //设置时间按钮
    private Button btnTimePicker;
    //小时
    private int mHour;
    // 分钟
    private int mMinute;
    //标识 dialog的id
    static final int TIME_DIALOG_ID = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        this.tvTimePickerDisplay = (TextView) this.findViewById(R.id.textView4conTime);
        this.btnTimePicker = (Button) findViewById(R.id.bt_settime);

        btnTimePicker.setOnClickListener(listener);
        // 获取当前时间
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);
        //显示当前时间
        updateDisplay();
    }


    private OnClickListener listener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            showDialog(TIME_DIALOG_ID);
            //设置时间
            MainActivity.writeDiaryTime_Hour = mHour;
            MainActivity.writeDiaryTime_Minute = mMinute;
        }
    };

    // updates the time we display in the TextView
    private void updateDisplay() {
        tvTimePickerDisplay.setText(new StringBuilder().append(pad(mHour)).append(":")
                .append(pad(mMinute)));

    }

    private static String pad(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }

    // 用户在对话框中“设置”时间时收到的回调
    private TimePickerDialog.OnTimeSetListener mTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            mHour = hourOfDay;
            mMinute = minute;
            updateDisplay();
        }
    };
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case TIME_DIALOG_ID:
                TimePickerDialog timePickerDialog = new TimePickerDialog(this, mTimeSetListener, mHour, mMinute,
                        true);
                return timePickerDialog;

        }
        return null;
    }


}
