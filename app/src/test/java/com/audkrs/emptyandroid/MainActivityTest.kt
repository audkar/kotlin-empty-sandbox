package com.audkrs.emptyandroid

import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.android.synthetic.main.activity_main.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.LooperMode

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
@LooperMode(LooperMode.Mode.LEGACY)
class MainActivityUnitTest {

    @Rule(order = 0)
    @JvmField
    val rule = HiltAndroidRule(this)
    @Rule(order = 1)
    @JvmField
    val scenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun name() {
        val scenario = scenarioRule.scenario
        scenario.moveToState(Lifecycle.State.RESUMED)

        scenario.onActivity {
            assertThat(it.hello_text.text).isEqualTo("Hello World!")
            it.click_me.performClick()
        }

        onView(withId(R.id.hello_text))
            .check(matches(withText("BAZINGA")))
    }
}
