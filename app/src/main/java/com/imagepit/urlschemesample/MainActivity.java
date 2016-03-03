package com.imagepit.urlschemesample;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        String action = intent.getAction();

        //ローカルHTMLを表示
        WebView webView1 = (WebView)findViewById(R.id.webView);
        webView1.loadUrl("file:///android_asset/index.html");

//        Button button = (Button)findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Uri uri = Uri.parse("http://www.image-pit.com/urlscheme/");
//                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
//                startActivity(intent);
//            }
//        });



        if (Intent.ACTION_VIEW.equals(action)) {
            Uri uri = intent.getData();
            if (uri != null) {

                String param1 = uri.getQueryParameter("code");
                Log.d("debug","param1:" + param1);
                Toast.makeText(this, "URLスキーム param1:" + param1, Toast.LENGTH_LONG).show();
            }
        }
    }
}
