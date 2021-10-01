package com.example.student_time;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class P2AsyncTime extends AppCompatActivity {
    Button S1,S2;
    private Button button;
    private EditText time;
    private TextView finalResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p2_async_time);
        S1=findViewById(R.id.play);
        S2=findViewById(R.id.stop);
        time = (EditText) findViewById(R.id.in_time);
        button = (Button) findViewById(R.id.play);
        finalResult = (TextView) findViewById(R.id.tv_result);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncTaskRunner runner = new AsyncTaskRunner();
                String sleepTime = time.getText().toString();

                runner.execute(sleepTime);
            }
        });
        S2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Stop service",Toast.LENGTH_SHORT).show();
                stopService(new Intent(getApplicationContext(),MyServices.class));
            }
        });
    }
    private class AsyncTaskRunner extends AsyncTask<String, String, String> {

        private String resp;
        ProgressDialog progressDialog;

        @Override
        protected String doInBackground(String... params) {
            publishProgress("Sleeping..."); // Calls onProgressUpdate()
            try {
                int time = Integer.parseInt(params[0]) * 1000;

                Thread.sleep(time);
                resp = "Slept for " + params[0] + " seconds";
            } catch (InterruptedException e) {
                e.printStackTrace();
                resp = e.getMessage();
            } catch (Exception e) {
                e.printStackTrace();
                resp = e.getMessage();
            }
            return resp;
        }


        @Override
        protected void onPostExecute(String result) {
            // execution of result of Long time consuming operation
            progressDialog.dismiss();
            Toast.makeText(getApplicationContext(),"Start service",Toast.LENGTH_SHORT).show();
            startService(new Intent(getApplicationContext(),MyServices.class));
            finalResult.setText(result);
            finalResult.setText(result);
        }


        @Override
        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(P2AsyncTime.this,
                    "ProgressDialog",
                    "Wait for " + time.getText().toString() + " seconds");
        }


        @Override
        protected void onProgressUpdate(String... text) {
            finalResult.setText(text[0]);

        }
    }
}