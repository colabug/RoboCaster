package com.greenlifesoftware.robolectricpractice;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowIntent;

import static com.greenlifesoftware.robolectricpractice.support.Assert.assertViewIsVisible;
import static com.greenlifesoftware.robolectricpractice.support.ResourceLocator.*;
import static com.greenlifesoftware.robolectricpractice.support.ViewLocator.getButton;
import static com.greenlifesoftware.robolectricpractice.support.ViewLocator.getEditText;
import static com.greenlifesoftware.robolectricpractice.support.ViewLocator.getTextView;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.robolectric.Shadows.*;
import static org.robolectric.shadows.ShadowToast.getTextOfLatestToast;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class RobolectricActivityTest
{
    private RobolectricActivity activity;
    private Button hintButton;
    private Button loginButton;

    @Before
    public void setUp() throws Exception
    {
        activity = Robolectric.setupActivity( RobolectricActivity.class );
        hintButton = getButton( activity, R.id.hint_button );
        loginButton = getButton( activity, R.id.login_button );
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
                    equalTo( getString( R.string.WELCOME_TEXT ) ) );
    }

    @Test
    public void shouldHaveNameEntry() throws Exception
    {
        EditText nameEntry = getEditText( activity, R.id.name_entry );
        assertViewIsVisible( nameEntry );
        assertThat( nameEntry.getHint().toString(),
                    equalTo( getString( R.string.NAME_ENTRY_HINT ) ) );
    }

    @Test
    public void shouldHaveHintButton() throws Exception
    {
        assertViewIsVisible( hintButton );
        assertThat( hintButton.getText().toString(),
                    equalTo( getString( R.string.HINT_BUTTON_TEXT ) ) );
    }

    @Test
    public void shouldShowHintWhenClicked() throws Exception
    {
        hintButton.performClick();
        assertThat( getTextOfLatestToast(),
                    equalTo( getString( R.string.HINT_TEXT ) ) );
    }

    @Test
    public void shouldHaveLoginButton() throws Exception
    {
        assertViewIsVisible( loginButton );
        assertThat( loginButton.getText().toString(),
                    equalTo( getString( R.string.LOGIN_BUTTON_TEXT ) ) );
    }

    @Test
    public void shouldLoginWhenLoginButtonClicked() throws Exception
    {
        loginButton.performClick();

        ShadowActivity shadowActivity = shadowOf( activity );
        Intent intent = shadowActivity.getNextStartedActivity();
        ShadowIntent shadowIntent = shadowOf( intent );
        assertEquals( shadowIntent.getComponent().getClassName(),
                      SecondActivity.class.getName() );
    }
}