package com.example.menu;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.graphics.HardwareRenderer;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainMenu extends AppCompatActivity{

    MediaPlayer title;
    private int menuNumber = -1;
    private String[] dataMenu = new String[]{"MINI EXERCISES","KEYBOARD EXERCISES","ALERT EXERCISES",
                                                "CAFE EXERCISES"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        title = MediaPlayer.create(this, R.raw.khtitle);
        title.setLooping(true);
        title.start();


        ListView listView = findViewById(R.id.list);
        //ArrayList doesn't work must be String[] dataMenu
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, R.layout.listview_item, dataMenu);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view.setSoundEffectsEnabled(false);
                view.setSelected(true);
                menuSound();
                menuNumber = position;
            }
        });
        System.out.println("jaja");
        listView.setAdapter(arrayAdapter);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        title.stop();
    }

    public void gotoActivity(View v){
        Intent intent;
        if(menuNumber!=-1){
            switch (menuNumber){
                case 0:
                    intent = new Intent(this, MiniActivities.class);
                    startActivity(intent);
                    break;
                case 1:
                    intent = new Intent(this, KeyboardStuff.class);
                    startActivity(intent);
                    break;
                case 2:
                    intent = new Intent(this, Alerts.class);
                    startActivity(intent);
                    break;
                case 3:
                    intent = new Intent(this, DroidCafe.class);
                    startActivity(intent);
                    break;
            }
            title.stop();
            MediaPlayer mp = MediaPlayer.create(this, R.raw.khselect);
            mp.start();
        }else{
            Toast.makeText(getApplicationContext(), "Please select one", Toast.LENGTH_SHORT).show();
            MediaPlayer mp = MediaPlayer.create(this, R.raw.kherror);
            mp.start();
        }
    }

    private void menuSound(){
        MediaPlayer mp = MediaPlayer.create(this, R.raw.khmenu);
        mp.start();
    }
}
