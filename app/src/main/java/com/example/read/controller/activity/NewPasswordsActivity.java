package com.example.read.controller.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.read.R;
import com.example.read.model.bean.User;
import com.example.read.model.db.MyOpenHelper;

import java.util.ArrayList;

public class NewPasswordsActivity extends AppCompatActivity implements View.OnClickListener {
    private Button sava;
    private ImageView seeting_clean;
    private EditText seetingPassword;
    private String name;
    private MyOpenHelper helper;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_password);
        helper = new MyOpenHelper(this);
        init();
    }

    private void init() {
        sava = findViewById(R.id.sava);
        seeting_clean = findViewById(R.id.seeting_clean);
        seetingPassword = findViewById(R.id.seetingPassword);
        seeting_clean.setOnClickListener(this);
        sava.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            // 返回按钮
            case R.id.seeting_clean:
                finish();
                break;
            // 保存按钮
            case R.id.sava:
                isSava();
                break;
        }
    }

    private void isSava() {
        String savaPassword = seetingPassword.getText().toString().trim();
        name = getIntent().getStringExtra("forget_Name");
        Log.i("忘记密码页面传过来的账号名",  name);
        if (!TextUtils.isEmpty(savaPassword)){
            ArrayList<User> data = helper.getAllData();
            for (int i =0 ;i< data.size();i++){
                User user = data.get(i);
                Log.i("数据库中账号", user.getName());
                if (name.equals(user.getName())){
                    Log.i("数据库中账号", user.getName()+"---------------");
                    helper.updata(savaPassword);
                    Intent intent = new Intent(this,LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }else{
            Toast.makeText(this, "请输入要修改的密码！", Toast.LENGTH_SHORT).show();
        }

    }
}
