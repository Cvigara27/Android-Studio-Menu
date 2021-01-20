package com.example.menu;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DroidCafe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cafe_layout);
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

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void showOrder(View v){
        String tag = v.getTag().toString();
        switch (tag){
            case "donut":
                displayToast(getString(R.string.donut_order_message));
                break;
            case "iceCream":
                displayToast(getString(R.string.ice_cream_order_message));
                break;
            case "froyo":
                displayToast(getString(R.string.froyo_order_message));
                break;
        }

        Intent intent = new Intent(this, OrderActivity.class);
        startActivity(intent);
    }
}
