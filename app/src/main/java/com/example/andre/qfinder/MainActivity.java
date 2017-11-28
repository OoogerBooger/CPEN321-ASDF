package com.example.andre.qfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;

import static android.provider.AlarmClock.EXTRA_MESSAGE;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    /**
     * Mobile Service Client reference
     */
    private MobileServiceClient mClient;

    /**
     * Mobile Service Table used to access data
     */
    private MobileServiceTable<Room> mRoomTable;

    private PopupWindow popupWindow;
    private LayoutInflater layoutInflater;
    //private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*AzureServiceAdapter.Initialize(this);
        mClient = AzureServiceAdapter.getInstance().getClient();
        mRoomTable = mClient.getTable(Room.class);*/
    }

    /** Called when the user taps the Send button */
   /* public void sendMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }*/

    /** Called when the user tries to enter room */
    public void enterRoom(View view) {

        // Do something in response to button
        Intent intent = new Intent(this, GuestWaitRoom.class);
        Intent intent2 = new Intent(this, InvalidRoomCode.class);
        EditText editText2 = (EditText) findViewById(R.id.editText2);

        String room_code = editText2.getText().toString();


        // If valid room_code then send to room.
        // Else give popup that it's invalid room.
        /* TODO INSERT CODE TO CHECK IF ROOM IS VALID IN TABLES  */
        if ( room_code.equals("asdf")  ) {
            intent.putExtra(EXTRA_MESSAGE, room_code);
            startActivity(intent);
        }
        else {
            intent2.putExtra(EXTRA_MESSAGE, room_code);
            startActivity(intent2);
        }
        /*
        intent.putExtra(EXTRA_MESSAGE, room_code);
        startActivity(intent);
        */
    }

    public void createRoom(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, EnterRoomActivity.class);

        int Min = 10000;
        int Max = 99999;
        String room_code;

        // Generate random code from [10000,99999] inclusive
        int int_code = Min + (int)(Math.random() * ((Max - Min) + 1));
        //int int_code = 12345;
        room_code = Integer.toString(int_code);
        //Room newRoom = new Room(room_code);
        //newRoom.generateQuiz();
        //mRoomTable.insert(newRoom);

        intent.putExtra(EXTRA_MESSAGE,room_code);
        startActivity(intent);
    }


}
