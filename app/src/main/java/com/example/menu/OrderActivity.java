package com.example.menu;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_layout);
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void onRadioClicked(View v){
        boolean checked = ((RadioButton) v).isChecked();
        switch (v.getId()){
            case R.id.sameday:
                if (checked){
                    displayToast(getString(R.string.chosen)+getString(R.string.same_day));;
                }
                break;
        case R.id.nextday:
            if (checked){
                displayToast(getString(R.string.chosen)+getString(R.string.next_day));;
            }
            break;
        case R.id.pickup:
            if (checked){
                displayToast(getString(R.string.chosen)+getString(R.string.pick_up));;
            }
            break;
        }
    }
}
