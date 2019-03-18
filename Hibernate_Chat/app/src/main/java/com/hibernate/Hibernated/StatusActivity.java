package com.hibernate.Hibernated;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StatusActivity extends AppCompatActivity {
    Button btnStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        btnStatus = findViewById(R.id.btnStatus);
    }
}
