package com.example.read.controller.activity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.read.R;
import com.example.read.controller.fragment.MeFragment;
import com.example.read.model.bean.User;
import com.example.read.model.db.MyOpenHelper;
import com.example.read.utils.Invisible;

import java.util.ArrayList;

//登陆页面
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_terms, tv_policy, login_cut, login_headline, register_password;
    private RelativeLayout login_content_phone, login_content_register;
    private Button login,register;
    private EditText loginName, loginPassword,registerName,registerPassword,registerNewPassword;
    private MyOpenHelper helper;
    private ImageView login_clean;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        helper = new MyOpenHelper(this);
    }

    private void init() {
        tv_terms = findViewById(R.id.tv_terms);
        tv_policy = findViewById(R.id.tv_policy);
        login_cut = findViewById(R.id.login_cut);
        login_clean = findViewById(R.id.login_clean);
        register_password = findViewById(R.id.register_password);
        login_content_phone = findViewById(R.id.login_content_phone);
        login_content_register = findViewById(R.id.login_content_register);
        login_headline = findViewById(R.id.login_headline);
        login = findViewById(R.id.login);//登陆
        register = findViewById(R.id.register);//注册
        loginName = findViewById(R.id.loginName);//登陆的账号
        loginPassword = findViewById(R.id.loginPassword);//登陆的密码
        registerName = findViewById(R.id.registerName);//注册的账号
        registerPassword = findViewById(R.id.registerPassword);//注册的密码
        registerNewPassword = findViewById(R.id.registerNewPassword);//注册的确定密码


        tv_terms.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);//下划线
        tv_policy.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        tv_terms.getPaint().setAntiAlias(true);//去掉锯齿
        tv_policy.getPaint().setAntiAlias(true);
        login_cut.setOnClickListener(this);
        login_content_register.setOnClickListener(this);
        register_password.setOnClickListener(this);
        login.setOnClickListener(this);
        register.setOnClickListener(this);
        login_clean.setOnClickListener(this);

        login_content_register.setVisibility(View.GONE);
    }


    // 单击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // 这是 返回按钮
            case R.id.login_clean:
                finish();
                break;
            // 这是手机快捷登陆
            case R.id.login_cut:
                login_content_phone.setVisibility(View.GONE);
                login_content_register.setVisibility(View.VISIBLE);
                login_headline.setText("注册账号登陆");
                break;
            // 这是账号密码登陆
            case R.id.login_content_register:
                login_content_phone.setVisibility(View.VISIBLE);
                login_content_register.setVisibility(View.GONE);
                login_headline.setText("账号密码登陆");
                break;
            // 这是忘记密码
            case R.id.register_password:
                Intent intent = new Intent(this,ForgetPasswordActivity.class);
                startActivity(intent);
                break;
            // 这是 登陆按钮
            case R.id.login:
                btuLogin();
                break;
            // 这是 注册按钮
            case R.id.register:
                btuRegister();
                break;
        }
    }

    // 这是注册按钮
    private void btuRegister() {
        String  re_name = registerName.getText().toString().trim();
        String  re_password = registerPassword.getText().toString().trim();
        String  re_new_password = registerNewPassword.getText().toString().trim();
        if (!TextUtils.isEmpty(re_name) && !TextUtils.isEmpty(re_password) && !TextUtils.isEmpty(re_new_password)){
            if (re_password.equals(re_new_password)){
                helper.add(re_name,re_password);
                login_content_phone.setVisibility(View.VISIBLE);
                login_content_register.setVisibility(View.GONE);
            }else{
                Toast.makeText(this, "两次密码不一致，请重新输入！", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "未完善信息，注册失败!", Toast.LENGTH_SHORT).show();
        }
    }

    //这是登陆按钮
    private void btuLogin() {

        String ed_name = loginName.getText().toString().trim();
        String ed_password = loginPassword.getText().toString().trim();
        if (!TextUtils.isEmpty(ed_name) && !TextUtils.isEmpty(ed_password)) {
            ArrayList<User> data = helper.getAllData();
            if (data.size() != 0){
                for (int i =0 ;i< data.size();i++){
                    User user = data.get(i);
                    if (ed_name.equals(user.getName()) && ed_password.equals(user.getPassword())){
                        Invisible.invisible = true;
                        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                        intent.putExtra("userName",user.getName());
                        startActivity(intent);
                        Log.i("登陆的-----", "itInvisible: "+ Invisible.invisible);
                        finish();
                        break;
                    }else {
                        Toast.makeText(this, "您的账号或密码输入错误，请重新输入", Toast.LENGTH_SHORT).show();
                    }
                }
            }else{
                Toast.makeText(this, "您输入的账号为空，请先注册！", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "输入的账号或密码不能为空！", Toast.LENGTH_SHORT).show();
        }
    }


    //重写activity的三个方法，设置它启动进入的方式和摧毁activity的方式
    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.slide_bottom_in, R.anim.silde_bottom_out);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        overridePendingTransition(R.anim.slide_bottom_in, R.anim.silde_bottom_out);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_bottom_in, R.anim.silde_bottom_out);
    }

}
