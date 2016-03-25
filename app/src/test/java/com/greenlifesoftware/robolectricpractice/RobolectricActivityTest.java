package com.greenlifesoftware.robolectricpractice;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class RobolectricActivityTest
{
    private RobolectricActivity activity;

    @Before
    public void setUp() throws Exception
    {
        activity = Robolectric.setupActivity( RobolectricActivity.class );
    }

    @Test
    public void shouldNotBeNull() throws Exception
    {
        assertNotNull( activity );
    }

    @Test
    public void shouldHaveTitle() throws Exception
    {
        assertThat( activity.getTitle().toString(),
                    equalTo( RuntimeEnvironment.application.getString( R.string.app_name ) ) );
    }
}