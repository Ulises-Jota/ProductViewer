package com.cursosandroidant.productviewer

import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityReduceQuantityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun mainActivityReduceQuantityTest() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        Thread.sleep(500)

        val textView = onView(
            allOf(
                withId(R.id.tvQuantity), withText("Disponibles: 343"),
                withParent(withParent(withId(android.R.id.content))),
                isDisplayed()
            )
        )
        textView.check(matches(withText("Disponibles: 343")))

        val appCompatImageButton = onView(
            allOf(
                withId(R.id.ibSum),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    5
                ),
                isDisplayed()
            )
        )
        appCompatImageButton.perform(click())

        val textInputEditText = onView(
            allOf(
                withId(R.id.etNewQuantity), withText("2"), withContentDescription("cantidad"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.tilNewQuantity),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        textInputEditText.perform(click())

        val textInputEditText2 = onView(
            allOf(
                withId(R.id.etNewQuantity), withText("2"), withContentDescription("cantidad"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.tilNewQuantity),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        textInputEditText2.perform(replaceText("25"))

        val textInputEditText3 = onView(
            allOf(
                withId(R.id.etNewQuantity), withText("25"), withContentDescription("cantidad"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.tilNewQuantity),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        textInputEditText3.perform(closeSoftKeyboard())

        val textInputEditText4 = onView(
            allOf(
                withId(R.id.etNewQuantity), withText("25"), withContentDescription("cantidad"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.tilNewQuantity),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        textInputEditText4.perform(pressImeActionButton())

        val appCompatImageButton2 = onView(
            allOf(
                withId(R.id.ibSum),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    5
                ),
                isDisplayed()
            )
        )
        appCompatImageButton2.perform(click())

        val appCompatImageButton3 = onView(
            allOf(
                withId(R.id.ibSum),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    5
                ),
                isDisplayed()
            )
        )
        appCompatImageButton3.perform(click())

        val appCompatImageButton4 = onView(
            allOf(
                withId(R.id.ibSub),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        appCompatImageButton4.perform(click())

        val extendedFloatingActionButton = onView(
            allOf(
                withId(R.id.efab), withText("Añadir al carrito"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        extendedFloatingActionButton.perform(click())

        val textView2 = onView(
            allOf(
                withId(R.id.tvQuantity), withText("Disponibles: 317"),
                withParent(withParent(withId(android.R.id.content))),
                isDisplayed()
            )
        )
        textView2.check(matches(withText("Disponibles: 317")))
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
