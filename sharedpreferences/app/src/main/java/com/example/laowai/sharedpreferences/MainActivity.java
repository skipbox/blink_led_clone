package com.example.laowai.sharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

//      >>>>Setting values in Preference:
//// MY_PREFS_NAME - a static String variable like:
////>>> goes outside the function  >>>public static final String MY_PREFS_NAME = "MyPrefsFile";
//        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
//        editor.putString("name", "Elena");
//        editor.putInt("idName", 12);
//        editor.apply();
//       >>> Retrieve data from preference:
//        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
//        String restoredText = prefs.getString("text", null);
//        if (restoredText != null) {
//        String name = prefs.getString("name", "No name defined");//"No name defined" is the default value.
//        int idName = prefs.getInt("idName", 0); //0 is the default value.
//        }
//or


//++ Create SharedPreferences
//         SharedPreferences pref = getApplicationContext().getSharedPreferences("my_shared_pref", MODE_PRIVATE);
//         Editor editor = pref.edit();
//         Storing data as KEY/VALUE pair
//
//         editor.putString("key_name_1", "string value 111");  // Saving string
//         editor.putString("key_name_2", "string value 222");  // Saving string
//         editor.putString("key_name_3", "string value 333");  // Saving string
////++ Save the changes in SharedPreferences
//         editor.commit(); // commit changes
//         Get SharedPreferences data
//
////++ If value for key not exist then return second param value - In this case null
//         String saved_email=pref.getString("key_name_1", "empty");         // getting String
//         String saved_username=pref.getString("key_name_2", null);         // getting String
//         String saved_url_code=pref.getString("key_name_3", null);         // getting String
//
////++ Save the changes in SharedPreferences
//         editor.commit(); // commit changes
//         Clear all data from SharedPreferences
//
//         editor.clear();
//         editor.commit(); // commit changes

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);

                    open_activity();

                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
    /** need this to open another activity*/
    public void open_activity() {
        Intent intent = new Intent(this, Main2Activity.class);
        //EditText editText = (EditText) findViewById(R.id.editText);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    public static final String my_settings_xxx = "MyPrefsFile";
    //button clicks------------------------------------------------------------------
    public void buttonOnClick(View view) {
        int the_id = view.getId();
        //Toast.makeText(this, "xxx", Toast.LENGTH_SHORT).show();
        if (the_id == R.id.b1) {
            Toast.makeText(this, "b1", Toast.LENGTH_SHORT).show();

            // MY_PREFS_NAME - a static String variable like:
////public static final String MY_PREFS_NAME = "MyPrefsFile";
//            SharedPreferences.Editor editor = getSharedPreferences(my_settings_xxx, MODE_PRIVATE).edit();
//            editor.putString("key_first_name", "John");
//            editor.putString("key_id", "5544234");
//            editor.putString("key_url", "http://www.dreamgoals.info");
//            editor.apply();
//            Toast.makeText(this, "Data saved to shared preferences successfully", Toast.LENGTH_SHORT).show();
        }
        if (the_id == R.id.b2) {
            Toast.makeText(this, "222", Toast.LENGTH_SHORT).show();
            //mTextMessage.setText("222222222222222");

        SharedPreferences prefs = getSharedPreferences(my_settings_xxx, MODE_PRIVATE);
        String xxx = prefs.getString("key_first_name","default_default");
        mTextMessage.setText(xxx);
        }
        if (the_id == R.id.b3) {
            //Toast.makeText(this, "333", Toast.LENGTH_SHORT).show();
            //how to set to automatically import class ?
            SharedPreferences prefs = getSharedPreferences(my_settings_xxx, MODE_PRIVATE);
            String xxx = prefs.getString("key_url","default_default");
            mTextMessage.setText(xxx);
        }
    }
}
