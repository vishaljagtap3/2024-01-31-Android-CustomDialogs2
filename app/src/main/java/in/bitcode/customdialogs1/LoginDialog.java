package in.bitcode.customdialogs1;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginDialog extends Dialog {

    private EditText edtUsername, edtPassword;
    private Button btnLogin;
    private Context context;

    interface OnLoginListener {
        void onSuccess(LoginDialog loginDialog);
        void onFail(LoginDialog loginDialog);
    }

    private OnLoginListener onLoginListener = null;

    public void setOnLoginListener(OnLoginListener onLoginListener) {
        this.onLoginListener = onLoginListener;
    }

    public LoginDialog(Context context) {
        super(context);
        this.context = context;
        initViews();

        btnLogin.setOnClickListener(new BtnLoginClickListener());
    }

    private class BtnLoginClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if(edtUsername.getText().toString().equals("bitcode") && edtPassword.getText().toString().equals("bitcode")) {
                if(onLoginListener != null) {
                    onLoginListener.onSuccess(LoginDialog.this);
                }
            }
            else {
                if(onLoginListener != null) {
                    onLoginListener.onFail(LoginDialog.this);
                }
            }
        }
    }

    private void mt(String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

    private void initViews() {
        setContentView(R.layout.login_dialog);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
    }
}
