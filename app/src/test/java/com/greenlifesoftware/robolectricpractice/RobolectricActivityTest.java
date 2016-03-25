package com.greenlifesoftware.robolectricpractice;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.greenlifesoftware.robolectricpractice.support.ViewLocator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static com.greenlifesoftware.robolectricpractice.support.Assert.assertViewIsVisible;
import static com.greenlifesoftware.robolectricpractice.support.ResourceLocator.*;
import static com.greenlifesoftware.robolectricpractice.support.ViewLocator.getButton;
import static com.greenlifesoftware.robolectricpractice.support.ViewLocator.getEditText;
import static com.greenlifesoftware.robolectricpractice.support.ViewLocator.getTextView;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

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
                    equalTo( getString( R.string.app_name ) ) );
    }

    @Test
    public void shouldHaveWelcomeText() throws Exception
    {
        TextView welcomeText = getTextView( activity, R.id.welcome_text );
        assertViewIsVisible( welcomeText );
        assertThat( welcomeText.getText().toString(),
                    equalTo( getString( R.string.welcome_text ) ) );
    }

    @Test
    public void shouldHaveNameEntry() throws Exception
    {
        EditText nameEntry = getEditText( activity, R.id.name_entry );
        assertViewIsVisible( nameEntry );
        assertThat( nameEntry.getHint().toString(),
                    equalTo( getString( R.string.name_entry_hint ) ) );
    }

    @Test
    public void shouldHaveLoginButton() throws Exception
    {
        Button button = getButton( activity, R.id.login_button );
        assertViewIsVisible( button );
        assertThat( button.getText().toString(),
                    equalTo( getString( R.string.login_button ) ) );
    }

    @Test
    public void shouldHaveFragment() throws Exception
    {
        assertNotNull(activity.getFragmentManager().findFragmentById( R.id.fragment_view ));
    }
}