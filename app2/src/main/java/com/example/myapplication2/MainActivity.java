package com.example.myapplication2;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.liyan.myapplication.IMyAidlInterface;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    IMyAidlInterface mIMyAidlInterface;

    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mIMyAidlInterface = IMyAidlInterface.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mIMyAidlInterface = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.example.liyan.myapplication", "com.example.liyan.myapplication.MyService"));
        bindService(intent, conn, BIND_AUTO_CREATE);
    }

    public void onClickButton(View view) {
        try {
            int res = mIMyAidlInterface.add(4, 6);
            Log.i(TAG, "从服务端调用成功的结果：" + res);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(conn);
    }
}
