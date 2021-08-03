package com.myfirst.fragmentsevents;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class PriceDetailsFragment extends Fragment {

    private EditText mEtCurrency, mEtPrice;
    private Button mBtnPreview;
    private String title, description, startDate, endDate, startTime, endTime;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title = getArguments().getString("Title");
        description = getArguments().getString("Description");
        startDate = getArguments().getString("StartDate");
        endDate = getArguments().getString("EndDate");
        startTime = getArguments().getString("StartTime");
        endTime = getArguments().getString("EndTime");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_price_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        mEtCurrency = view.findViewById(R.id.currency);
        mEtPrice = view.findViewById(R.id.price);
        mBtnPreview = view.findViewById(R.id.preview);
        mBtnPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currency = mEtCurrency.getText().toString();
                String price = mEtPrice.getText().toString();
                Model model = new Model(title,description,startDate,endDate,startTime,endTime,currency,price);
                Intent intent = new Intent(getActivity(),PreviewActivity.class);
                intent.putExtra("Details",model);
                startActivity(intent);
            }
        });
    }
}