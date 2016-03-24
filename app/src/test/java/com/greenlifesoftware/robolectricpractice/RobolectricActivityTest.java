package com.greenlifesoftware.robolectricpractice;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class RobolectricActivityTest
{
    @Before
    public void setUp() throws Exception
    {
        RobolectricActivity activity = Robolectric.setupActivity( RobolectricActivity.class );
        assertNotNull( activity );
    }
}