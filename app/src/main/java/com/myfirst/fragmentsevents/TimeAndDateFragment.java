package com.myfirst.fragmentsevents;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class TimeAndDateFragment extends Fragment {

    private ClickListener clickListener;
    private EditText mEtStartDate, mEtEndDate, mEtStartTime, mEtEndTime;
    private Button mBtnNext;
    private String title, description;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        clickListener = (ClickListener) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title = getArguments().getString("Title");
        description = getArguments().getString("Description");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_time_and_date, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        mEtStartDate = view.findViewById(R.id.startDate);
        mEtEndDate = view.findViewById(R.id.endDate);
        mEtStartTime = view.findViewById(R.id.startTime);
        mEtEndTime = view.findViewById(R.id.endTime);
        mBtnNext = view.findViewById(R.id.next);
        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String startDate = mEtStartDate.getText().toString();
                String endDate = mEtEndDate.getText().toString();
                String startTime = mEtStartTime.getText().toString();
                String endTime = mEtEndTime.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("Title", title);
                bundle.putString("Description", description);
                bundle.putString("StartDate", startDate);
                bundle.putString("EndDate", endDate);
                bundle.putString("StartTime", startTime);
                bundle.putString("EndTime", endTime);
                bundle.putString("FragmentType","Time");
                clickListener.onClick(bundle);
            }
        });
    }
}