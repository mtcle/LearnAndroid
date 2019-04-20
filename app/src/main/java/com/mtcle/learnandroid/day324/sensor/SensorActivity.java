package com.mtcle.learnandroid.day324.sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.mtcle.customlib.common.CommonAcitivty;
import com.mtcle.customlib.common.utils.DebugUtil;
import com.mtcle.learnandroid.R;

import java.util.List;

import static android.hardware.SensorManager.SENSOR_DELAY_NORMAL;

/**
 * 作者：Lenovo on 2019/3/21 11:23
 * <p>
 * 邮箱：mtcle@126.com
 * <p>
 * 描述：
 */
public class SensorActivity extends CommonAcitivty {
    private TextView tvTip;

    private SensorManager sensorManager;

    @Override
    protected int getSubLayoutId() {
        return R.layout.activity_sensor;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tvTip = findViewById(R.id.tv_tip);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        List<Sensor> allSensor = sensorManager.getSensorList(Sensor.TYPE_ALL);
        for (Sensor s : allSensor) {
            DebugUtil.debug("传感器名称：" + s.getName());
        }


        sensorManager.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                DebugUtil.debug("检测到传感器变化：" + event.accuracy + ";" + event.values[0]);
                tvTip.setText("当前值：" + event.values[0]);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        }, sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT), SENSOR_DELAY_NORMAL);
    }


    @Override
    public void onLowMemory() {
        super.onLowMemory();
        //低内存，



        //




    }



}
