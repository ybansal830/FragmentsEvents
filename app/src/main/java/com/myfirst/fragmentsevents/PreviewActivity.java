package com.myfirst.fragmentsevents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PreviewActivity extends AppCompatActivity {

    private TextView mTvTitle, mTvDescription, mTvStartDate, mTvEndDate, mTvStartTime, mTvEndTime, mTvPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        initViews();
    }

    private void initViews() {
        mTvTitle = findViewById(R.id.title);
        mTvDescription = findViewById(R.id.description);
        mTvStartDate = findViewById(R.id.startDate);
        mTvEndDate = findViewById(R.id.endDate);
        mTvStartTime = findViewById(R.id.startTime);
        mTvEndTime = findViewById(R.id.endTime);
        mTvPrice = findViewById(R.id.price);
        setData();
    }

    private void setData() {
        Model model = (Model) getIntent().getSerializableExtra("Details");
        mTvTitle.setText(model.getTitle());
        mTvDescription.setText(model.getDescription());
        mTvStartDate.setText(model.getStartDate());
        mTvEndDate.setText(model.getEndDate());
        mTvStartTime.setText(model.getStartTime());
        mTvEndTime.setText(model.getEndTime());
        mTvPrice.setText(model.getCurrency() + " " + model.getPrice());
    }
}