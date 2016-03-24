package com.greenlifesoftware.robolectricpractice.support;

import android.app.Activity;
import android.widget.EditText;
import android.widget.TextView;

public class ViewLocator
{
    public static TextView getTextView( Activity activity, int viewId)
    {
        return (TextView) activity.findViewById( viewId );
    }

    public static EditText getEditText(Activity activity, int viewId)
    {
        return (EditText) activity.findViewById( viewId );
    }
}
