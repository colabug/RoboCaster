package com.greenlifesoftware.robolectricpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class RobolectricActivity extends AppCompatActivity
{
    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_robolectric );

        findViewById( R.id.hint_button ).setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View view )
            {
                Toast.makeText( RobolectricActivity.this, R.string.HINT_TEXT, Toast.LENGTH_SHORT )
                     .show();
            }
        } );

        findViewById( R.id.login_button).setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View view )
            {
                startActivity( SecondActivity.newIntent( RobolectricActivity.this ) );
            }
        } );
    }
}
