package com.audkrs.emptyandroid

import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.google.common.truth.Truth.assertThat
import kotlinx.android.synthetic.main.activity_main.*
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @Rule
    @JvmField
    val scenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun name() {
        val scenario = scenarioRule.scenario
        scenario.moveToState(Lifecycle.State.RESUMED)
        onView(withText("Hello World!")).check(
            matches(isCompletelyDisplayed())
        )

        scenario.onActivity {
            assertThat(it.hello_text.text).isEqualTo("Hello World!")
        }
    }
}
