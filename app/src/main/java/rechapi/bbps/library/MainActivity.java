package rechapi.bbps.library;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
//import android.util.Log;

import rechapi.bbps.bbpslibrary.AES;
import rechapi.bbps.bbpslibrary.bbpsStart;
public class MainActivity extends AppCompatActivity {

    private Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity = MainActivity.this;
        String key="tHeApAcHe6410111";
        String text="TEeY+YukQgWzk5wbs5OBQA==";
        String encrypted=AES.getEncrypted("Arnab Cfgfv vvv",key);

        Intent intent = new Intent(activity, bbpsStart.class);
        startActivity(intent);

    }
}