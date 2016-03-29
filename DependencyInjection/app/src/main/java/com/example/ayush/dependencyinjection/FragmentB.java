package com.example.ayush.dependencyinjection;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import javax.inject.Inject;

public class FragmentB extends Fragment implements View.OnClickListener {

    @Inject
    SharedPreferences mPreferences;

    private TextView mTextStored;
    private Button mBtnRefresh;

    public FragmentB() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((App)getActivity().getApplication()).getApplicationComponent().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        mTextStored = (TextView) view.findViewById(R.id.text_stored);
        mBtnRefresh = (Button) view.findViewById(R.id.btn_refresh);
        mBtnRefresh.setOnClickListener(this);
        loadStoredDataIntoTextView();
    }

    @Override
    public void onClick(View v) {
        loadStoredDataIntoTextView();
    }

    private void loadStoredDataIntoTextView() {
        String storedText = mPreferences.getString("key", "Nothing found yet");
        mTextStored.setText(storedText);
    }
}