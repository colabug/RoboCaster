package com.greenlifesoftware.robolectricpractice.support;

import org.robolectric.RuntimeEnvironment;

public class ResourceLocator
{
    public static String getString( int stringId )
    {
        return RuntimeEnvironment.application.getString( stringId );
    }
}
