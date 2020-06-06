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



public class CardFragment extends Fragment implements View.OnClickListener {

    private FrameLayout mFrameLayout;
    private CardView mCardView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_adapter, container, false);
        mCardView = view.findViewById(R.id.cardView);
        mCardView.setMaxCardElevation(mCardView.getCardElevation()
                * CardAdapter.MAX_ELEVATION_FACTOR);

        initView(view);
        return view;
    }

    //初始化绑定控件
    private void initView(View view) {
        mFrameLayout = view.findViewById(R.id.fragmentLayout_adapter);
        mFrameLayout.setOnClickListener(this);
    }

    public CardView getCardView() {
        return mCardView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fragmentLayout_adapter:
                Toast.makeText(getActivity(),"这是新圈pike",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
