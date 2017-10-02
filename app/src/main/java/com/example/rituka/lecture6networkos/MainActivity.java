package com.example.rituka.lecture6networkos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnDownload;
    TextView textView;
    public static final String TAG="SIZE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDownload = (Button) findViewById(R.id.btnDownload);
        textView = (TextView) findViewById(R.id.textView);

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new JSONDownloadClass() {
                    @Override
                    protected void onPostExecute(ArrayList<Post> posts) {
                        super.onPostExecute(posts);
                        Log.d(TAG,"onPostExecute: " + posts.size());
                        textView.setText(String.valueOf(posts));
                    }

                }.execute("https://jsonplaceholder.typicode.com/posts");
            }
        });
    }
}