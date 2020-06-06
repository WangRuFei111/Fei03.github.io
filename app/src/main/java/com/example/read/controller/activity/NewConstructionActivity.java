package com.example.read.controller.activity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.read.R;

// 我的书单中的新建按钮
public class NewConstructionActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mClean;
    private EditText content_edit;
    private Button content_btu;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_construction);
        init();
        initEdit();
    }

    //自动弹出软键盘
    private void initEdit() {
        content_edit.setFocusable(true);
        content_edit.setFocusableInTouchMode(true);
        content_edit.requestFocus();
        InputMethodManager inputManager = (InputMethodManager) content_edit.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.showSoftInput(content_edit, 0);
    }

    private void init() {
        mClean = findViewById(R.id.new_construction_clean);
        content_edit= findViewById(R.id.content_edit);
        content_btu = findViewById(R.id.content_btu);

        mClean.setOnClickListener(this);
        content_btu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.new_construction_clean:
                finish();
                break;
            case R.id.content_btu:
                isEditInput();
                break;
        }
    }

    // 判断输入框中的内容
    private void isEditInput() {
        String content = content_edit.getText().toString().trim();
        if (!TextUtils.isEmpty(content)){
            Toast.makeText(this,"暂时不能为您创建书单哦亲！",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"您输入的内容为空！",Toast.LENGTH_SHORT).show();
        }
    }
}
