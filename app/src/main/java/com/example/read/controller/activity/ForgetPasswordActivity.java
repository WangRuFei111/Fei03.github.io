package com.example.read.controller.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.read.R;
import com.example.read.model.bean.User;
import com.example.read.model.db.MyOpenHelper;

import java.util.ArrayList;

// 这是忘记密码的页面
public class ForgetPasswordActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView clean;
    private Button submit;
    private TextView forget_verification;
    private EditText forgetName,isVerificationCode;
    private MyOpenHelper helper;
    private String code, mEdit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        helper = new MyOpenHelper(this);

        init();
    }

    private void init() {
        clean = findViewById(R.id.forget_clean);
        submit = findViewById(R.id.submit);
        forgetName = findViewById(R.id.forgetName);
        isVerificationCode = findViewById(R.id.verification_code);
        forget_verification = findViewById(R.id.forget_verification);
        forget_verification.setOnClickListener(this);
        submit.setOnClickListener(this);
        clean.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //返回按钮
            case R.id.forget_clean:
                finish();
                break;
            //产生随机数验证码
            case R.id.forget_verification:
                code = createRandom(true, 4);
                Toast toastCenstr = Toast.makeText(getApplicationContext(), "" + code,
                        Toast.LENGTH_SHORT);
                toastCenstr.setGravity(Gravity.CENTER, 0, 0);
                toastCenstr.show();
                break;
            //提交
            case R.id.submit:
//                Intent intent = new Intent(this,SeetingActivity.class);
//                startActivity(intent);
                isNewPassword();
                break;
        }
    }

    private void isNewPassword() {
        String forget_Name = forgetName.getText().toString().trim();
        String verification = isVerificationCode.getText().toString().trim();
        ArrayList<User> data = helper.getAllData();
            //判断输入的账号和密码是否为空
            if (!TextUtils.isEmpty(forget_Name) && !TextUtils.isEmpty(verification)) {
                //循环数据库中的数据
                for (int i = 0; i < data.size(); i++) {
                    User user = data.get(i);
                    //判断是否有这个用户名
                    if (forget_Name.equals(user.getName())) {
                        //判断验证码是否正确
                        mEdit = isVerificationCode.getText().toString().trim();
                        if (mEdit.equalsIgnoreCase(code)) {
                            Intent intent = new Intent(this,NewPasswordsActivity.class);
                            intent.putExtra("forget_Name",forget_Name);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(this, "您的验证码有误", Toast.LENGTH_SHORT).show();
                            isVerificationCode.setText("");
                        }
                    } else {
                        Toast.makeText(this, "您的用户名不存在，请您重新输入", Toast.LENGTH_SHORT).show();
                    }
                }
            }else{
                Toast.makeText(this, "您的手机号或验证码为空！", Toast.LENGTH_SHORT).show();
            }
    }

    //产生随机数
    public String createRandom(boolean numberFlag, int length) {
        String retStr = "";
        String strTable = numberFlag ? "1234567890" : "1234567890abcdefghijkmnpqrstuvwxyz";
        int len = strTable.length();
        boolean bDone = true;
        do {
            retStr = "";
            int count = 0;
            for (int i = 0; i < length; i++) {
                double dblR = Math.random() * len;
                int intR = (int) Math.floor(dblR);
                char c = strTable.charAt(intR);
                if (('0' <= c) && (c <= '9')) {
                    count++;
                }
                retStr += strTable.charAt(intR);
            }
            if (count >= 2) {
                bDone = false;
            }
        } while (bDone);

        return retStr;
    }
}
