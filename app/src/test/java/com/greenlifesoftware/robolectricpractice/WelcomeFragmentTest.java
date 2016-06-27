package com.greenlifesoftware.robolectricpractice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;
import static org.robolectric.util.FragmentTestUtil.startFragment;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class WelcomeFragmentTest
{
    @Test
    public void shouldNotBeNull() throws Exception
    {
        WelcomeFragment fragment = WelcomeFragment.newInstance();
        startFragment( fragment );
        assertNotNull( fragment );
    }
}