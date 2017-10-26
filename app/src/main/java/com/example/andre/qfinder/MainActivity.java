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

import static android.provider.AlarmClock.EXTRA_MESSAGE;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    private PopupWindow popupWindow;
    private LayoutInflater layoutInflater;
    //private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    /** Called when the user tries to enter room */
    public void enterRoom(View view) {
        RelativeLayout relativeLayout;
        // Do something in response to button
        Intent intent = new Intent(this, EnterRoomActivity.class);
        EditText editText2 = (EditText) findViewById(R.id.editText2);

        String room_code = editText2.getText().toString();
        relativeLayout = (RelativeLayout) findViewById(R.id.relative);

        // If valid room_code then send to room.
        // Else give popup that it's invalid room.
        if ( room_code.equals("asdf")  ) {
            intent.putExtra(EXTRA_MESSAGE, room_code);
            startActivity(intent);
        }
        else {
            layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.roomcode_popup,null);

            popupWindow = new PopupWindow(container, 400, 400, true);
            popupWindow.showAtLocation(relativeLayout, Gravity.NO_GRAVITY, 500,500);

            container.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    popupWindow.dismiss();
                    return true;
                }
            });
        }
        /*
        intent.putExtra(EXTRA_MESSAGE, room_code);
        startActivity(intent);
        */
    }

    public void createRoom(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, EnterRoomActivity.class);
        startActivity(intent);
    }


}
