package hu.allusion.dry.bernard_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;


import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MessageActivity extends AppCompatActivity {

    final String BERNARD_MESSAGE_URL = "http://bernard-api.herokuapp.com/message/71";
    final long MIN_TIME = 5000;
    TextView mMessageField;
    ListView mListField;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        mMessageField = (TextView) findViewById(R.id.firstmessage);
        mListField = (ListView) findViewById(R.id.messageListView);


    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void getData(){
        AsyncHttpClient client = new AsyncHttpClient();

        client.get(BERNARD_MESSAGE_URL, new JsonHttpResponseHandler(){

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response){
                Message messageData = Message.fromJson(response);
                updateUI(messageData);

            }



        });
    }

    private void updateUI(Message message) {
        mMessageField.setText(message.getMessage());
    }


























}
