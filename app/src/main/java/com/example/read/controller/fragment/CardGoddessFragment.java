package com.example.read.controller.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.read.R;
import com.example.read.controller.adapter.CardAdapter;


public class CardGoddessFragment extends CardFragment implements View.OnClickListener {

    private CardView mCardView;
    private FrameLayout mFrameLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_adapter_goddess, container, false);
        mCardView = view.findViewById(R.id.cardViewGoddes);
        mCardView.setMaxCardElevation(mCardView.getCardElevation()
                * CardAdapter.MAX_ELEVATION_FACTOR);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mFrameLayout = view.findViewById(R.id.fragmentLayout_adapter_goddess);
        mFrameLayout.setOnClickListener(this);
    }

    public CardView getCardView() {
        return mCardView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fragmentLayout_adapter_goddess:
                Toast.makeText(getActivity(),"这是女神都在聊",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
