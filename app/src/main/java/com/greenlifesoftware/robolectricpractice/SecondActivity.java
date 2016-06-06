package com.greenlifesoftware.robolectricpractice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class SecondActivity extends Activity
{
    public static Intent newIntent( Context context )
    {
        return new Intent( context, SecondActivity.class );
    }
}
