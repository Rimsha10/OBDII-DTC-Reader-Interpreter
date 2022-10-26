package com.example.mydtcreader;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothSocket;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mydtcreader.command.DTCsCommand;
import com.example.mydtcreader.enums.Description;
import com.example.mydtcreader.enums.Detail;
import com.example.mydtcreader.response.DiagnosticTroubleCodeResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    EditText dtcip;
    TextView dtcRes;
    Button getdtc, dtc;
    String address, rawData,dtcstatusResponse,dtcintResponse,desc,input;
    DiagnosticTroubleCodeResponse dg1,dg2;
    DTCsCommand dtCsCommand;
    TroubleCode tc;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dtcip = findViewById(R.id.dtcinput);
        dtcRes = findViewById(R.id.dtcResult);
        getdtc = findViewById(R.id.button);
        dtc = findViewById(R.id.dtc);

        getdtc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean b = dtcip.getText().toString().length() < 5;
                if((dtcip.getText().toString().isEmpty())||(b) ){
                    Toast.makeText(MainActivity.this,"Invalid code",Toast.LENGTH_LONG).show();
                    return;
                }
                input = dtcip.getText().toString();
                String description=Description.getDescription(input);
                tc = TroubleCode.createFromString(input);
                if ((tc.isValid()) && (description!=null)){
                        try {
                    TroubleCode.Type type=tc.getType();
                    desc=tc.getDescription(input);
                    Detail detail=tc.getDetail();
                    dtcintResponse= tc.toString() + "\nTrouble causing Part: " +type
                                    +"\nGenre: " +detail + "\nDescription: "+ desc;
                    System.out.println(dtcintResponse);
                    dtcRes.setText("");
                    dtcRes.setText(dtcintResponse);
                    dtcip.setText("");

                       }catch (IOException e) {
                        e.printStackTrace();}
                }else{
                 Toast.makeText(MainActivity.this,"Invalid code",Toast.LENGTH_LONG).show();
                 return;
                    }
            }
        });
        dtc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    obdConnect();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this,"Error occured",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    /*private String getBluetoothMacAddress() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        String bluetoothMacAddress = "";
        try {
            Field mServiceField = bluetoothAdapter.getClass().getDeclaredField("mService");
            mServiceField.setAccessible(true);

            Object btManagerService = mServiceField.get(bluetoothAdapter);

            if (btManagerService != null) {
                bluetoothMacAddress = (String) btManagerService.getClass().getMethod("getAddress").invoke(btManagerService);
            }
        } catch (NoSuchFieldException | NoSuchMethodException | IllegalAccessException | InvocationTargetException ignore) {

        }
        return bluetoothMacAddress;
    }*/

    private void obdConnect() throws IOException {
        boolean b = dtcip.getText().toString().length() < 5;
        input = dtcip.getText().toString();
        if((dtcip.getText().toString().isEmpty())||(b)){
            Toast.makeText(MainActivity.this,"Invalid code",Toast.LENGTH_SHORT).show();
            return;
        }
        tc = TroubleCode.createFromString(input);
        if ((tc.getDescription(input)==null)||(!tc.isValid())) {
            Toast.makeText(MainActivity.this,"Invalid code",Toast.LENGTH_SHORT).show();
            return;
        }
        if ((ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_DENIED)
        ) {System.out.println("allowed");
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S)
            {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.BLUETOOTH_CONNECT}, 2);
            }
        }
        BluetoothAdapter BA = BluetoothAdapter.getDefaultAdapter();
        BluetoothManager bluetoothManager = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            bluetoothManager = getSystemService(BluetoothManager.class);
        }
        BluetoothAdapter bluetoothAdapter = bluetoothManager.getAdapter();
        if (bluetoothAdapter == null) {
            Toast.makeText(getApplicationContext(), "This feature cannot work on this device because it does not support bluetooth", Toast.LENGTH_LONG).show();
            // Device doesn't support Bluetooth
        } else if (!BA.isEnabled()) {
            BA.enable();
            //Toast.makeText(getApplicationContext(), "Bluetooth turned on", Toast.LENGTH_LONG).show();
        } else {
            //Toast.makeText(getApplicationContext(), "Bluetooth is already on", Toast.LENGTH_LONG).show();
            System.out.println("bluetooth on");
        }
        //String ad = getBluetoothMacAddress();
        //System.out.println(ad);
        address = BA.getAddress();
        System.out.println("take address");
        System.out.println(address);
        try {
            System.out.println("socket coming");
            BluetoothSocket mSocket = BA.getRemoteDevice("00:00:00:00:5A:AD").createRfcommSocketToServiceRecord(UUID.fromString("00001101-0000-1000-8000-00805f9b34fb"));
            System.out.println(mSocket);
            if (!mSocket.isConnected()) {
                try{
                    mSocket.connect();
                    Toast.makeText(MainActivity.this,"Connected successfully",Toast.LENGTH_SHORT).show();
                    //Toast.makeText(MainActivity.this,"Connecting to obd device",Toast.LENGTH_SHORT).show();
                    System.out.println("socket connect");
                }catch (IOException e){
                    Toast.makeText(MainActivity.this,"Error connecting",Toast.LENGTH_SHORT).show();
                    System.out.println("Error connecting");
                    return;
                }
            }
                InputStream in = mSocket.getInputStream();
                OutputStream outputStream = mSocket.getOutputStream();
                System.out.println("running");
                System.out.println(in);
                System.out.println(outputStream);
                dtCsCommand = new DTCsCommand();
                dtCsCommand.sendCommand(outputStream, dtcip.getText().toString());
                //Toast.makeText(MainActivity.this,"Command sent",Toast.LENGTH_SHORT).show();
                rawData = dtCsCommand.readRawData(in);
                Toast.makeText(MainActivity.this,"Response received",Toast.LENGTH_SHORT).show();
                //rawData =null;
                if (!rawData.equals("OK")) {
                    dg2 = new DiagnosticTroubleCodeResponse(rawData.toString().getBytes());
                    TroubleCode tc = dg2.getTroubleCode();
                    System.out.println(tc);
                    dtcstatusResponse=dg2.getFormattedString();
                    System.out.println(dtcstatusResponse);
                    dtcRes.setText("");
                    dtcRes.setText(dtcstatusResponse);
                    dtcip.setText("");
                    mSocket.close();
                }else {
                    dtcRes.setText("");
                    //dtcstatusResponse=dg2.getFormattedString();
                    dtcRes.setText(input+"-------OK");
                    dtcip.setText("");
                    System.out.println("OK");
                    mSocket.close();
                }

        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(MainActivity.this,"Error connecting",Toast.LENGTH_SHORT).show();
            return;
        }
    }
}
