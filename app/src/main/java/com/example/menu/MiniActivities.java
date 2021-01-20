package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MiniActivities extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mini_exercises);
    }

    public void changeColor(View v){
        TextView textColor = findViewById(R.id.colorChange);
        String checkBox = v.getResources().getResourceName(v.getId());
        System.out.println(checkBox);
        switch (checkBox){
            case "com.example.menu:id/red":
                textColor.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.red, 0);
                break;
            case "com.example.menu:id/green":
                textColor.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.green,0);
                break;
            case "com.example.menu:id/blue":
                textColor.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.blue,0);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        Intent intent = new Intent(this, MainMenu.class);
        MediaPlayer mp = MediaPlayer.create(this, R.raw.khcancel);
        mp.start();
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    public void changeText(View v){
        TextView text = findViewById(R.id.text);
        EditText edit = findViewById(R.id.edit);
        text.setText(edit.getText().toString());
    }

    public void checkCheckBox(View v){
        CheckBox checkBox = (CheckBox)v;
        boolean checked = checkBox.isChecked();
        if(checked){
            checkBox.setText("This CheckBox is: Checked");
        }else {
            checkBox.setText("This CheckBox is: Unchecked");
        }
    }

    public void makeSound(View v){
        MediaPlayer mp = MediaPlayer.create(this, R.raw.zoiberg);
        mp.start();
    }
}