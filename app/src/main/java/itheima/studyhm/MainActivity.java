package itheima.studyhm;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_username;
    private EditText et_pawword;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();


    }

    private void initViews() {

        et_username = (EditText) findViewById(R.id.et_username);
        et_pawword = (EditText) findViewById(R.id.et_password);
        btn_login = (Button) findViewById(R.id.btn_login);

        btn_login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn_login:

                login();

                break;


        }

    }

    private void login() {


        String username = et_username.getText().toString();
        String password = et_pawword.getText().toString();

        boolean checkUserInfo = checkUserInfo(username, password);

        if (checkUserInfo){

            ProgressDialog dialog = new ProgressDialog(this);
            dialog.show();

        }else {
            Toast.makeText(MainActivity.this,"登录失败!",Toast.LENGTH_LONG).show();
        }
    }

    private boolean checkUserInfo(String username, String password) {

        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
            return true;
        }

        return false;
    }
}
