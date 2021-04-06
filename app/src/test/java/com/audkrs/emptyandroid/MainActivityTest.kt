package com.audkrs.emptyandroid

import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.audkrs.emptyandroid.databinding.ActivityMainBinding
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
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
            val binding = ActivityMainBinding.bind(it.requireViewById(R.id.activity_content))
            assertThat(binding.helloText.text).isEqualTo("Hello World!")
            binding.clickMe.performClick()
        }

        onView(withId(R.id.hello_text))
            .check(matches(withText("BAZINGA")))
    }
}
