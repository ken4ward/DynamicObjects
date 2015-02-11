package com.example.ken4ward.dynamiclayout;

import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.widget.EditText;
import android.graphics.Color;
import android.content.res.Resources;
import android.util.TypedValue;


@SuppressWarnings("ALL")
public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
       //setting new instance of a custom layout
        RelativeLayout layout = new RelativeLayout(this);

        //set background color ofr the layout
        layout.setBackgroundColor(Color.GREEN);

        EditText username = new EditText(this);
        username.setId(1);
        //create new instance of button
        Button button = new Button(this);
        button.setId(2);

        //set button text
        button.setText("Sign In");

        //set color for button
        button.setBackgroundColor(Color.RED);

        RelativeLayout.LayoutParams usernameDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT );

        //wrapping contents on the layout
        RelativeLayout.LayoutParams layoutContent = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT );

        //adding rules for contents
        usernameDetails.addRule(RelativeLayout.ABOVE, button.getId());
        usernameDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        usernameDetails.setMargins(0, 0, 0, 50);

        //this is used to covert from pixel to dpi
        Resources resource = getResources();
        int pixel = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200, resource.getDisplayMetrics());

        //the value is used to seet the width of the textbox
        username.setWidth(pixel);

        //adding rules for contents
        layoutContent.addRule(RelativeLayout.CENTER_HORIZONTAL);
        layoutContent.addRule(RelativeLayout.CENTER_VERTICAL);

        //add button to layout and positioning
        layout.addView(button, layoutContent);
        layout.addView(username, usernameDetails);

       // layout.addView(button);
        setContentView(layout);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
