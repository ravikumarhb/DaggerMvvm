package com.example.dagger

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import com.example.dagger.adapter.NewsAdapter
import com.example.dagger.utils.IdlingResource
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class ExampleInstrumentedTest {

    @Before
    fun before() {
        IdlingRegistry.getInstance().register(IdlingResource.countingResource)
    }

    @After
    fun after() {
        IdlingRegistry.getInstance().unregister(IdlingResource.countingResource)
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.dagger", appContext.packageName)
    }


    // Test main activity
    @Test
    fun testMainActivity() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.container)).check(matches(isDisplayed()))
    }


    //Test Main Fragment launch
    @Test
    fun testMainFragment() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.main)).check(matches((isDisplayed())))

        onView(withId(R.id.recycler_view))
            .perform(RecyclerViewActions.scrollToPosition<NewsAdapter.NewsViewHolder>(1))

    }

    //Test detail fragment launch
    @Test
    fun testDetailFragmentLaunch() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.main)).check(matches((isDisplayed())))

        onView(withId(R.id.recycler_view))
            .perform(RecyclerViewActions.scrollToPosition<NewsAdapter.NewsViewHolder>(1))

        onView(withId(R.id.recycler_view))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<NewsAdapter.NewsViewHolder>(
                    1,
                    click()
                )
            )

        onView(withId(R.id.detail_root)).check(matches(isDisplayed()))

    }

    @Test
    fun testDetailToMainFragmentNavigation() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.main)).check(matches((isDisplayed())))

        onView(withId(R.id.recycler_view))
            .perform(RecyclerViewActions.scrollToPosition<NewsAdapter.NewsViewHolder>(1))

        onView(withId(R.id.recycler_view))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<NewsAdapter.NewsViewHolder>(
                    1,
                    click()
                )
            )

        onView(withId(R.id.detail_root)).check(matches(isDisplayed()))
        pressBack()

    }
}
