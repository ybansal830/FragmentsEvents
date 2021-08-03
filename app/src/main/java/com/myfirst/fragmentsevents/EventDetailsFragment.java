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


public class EventDetailsFragment extends Fragment {

    private ClickListener clickListener;
    private EditText mEtTitle,mEtDescription;
    private Button mBtnNext;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        clickListener = (ClickListener) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        mEtTitle = view.findViewById(R.id.title);
        mEtDescription = view.findViewById(R.id.description);
        mBtnNext = view.findViewById(R.id.next);
        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = mEtTitle.getText().toString();
                String description = mEtDescription.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("Title",title);
                bundle.putString("Description",description);
                bundle.putString("FragmentType","Event");
                clickListener.onClick(bundle);
            }
        });
    }
}