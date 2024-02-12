package in.bitcode.customdialogs1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSignIn = findViewById(R.id.btnSignIn);

        btnSignIn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        LoginDialog loginDialog = new LoginDialog(MainActivity.this);
                        loginDialog.setOnLoginListener(new MyOnLoginListener());
                        loginDialog.show();
                    }
                }
        );
    }

    private class MyOnLoginListener implements LoginDialog.OnLoginListener {
        @Override
        public void onSuccess(LoginDialog loginDialog) {
            mt("My Success action");
            loginDialog.dismiss();
        }

        @Override
        public void onFail(LoginDialog loginDialog) {
            mt("My fail action");
        }
    }

    private void mt(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}