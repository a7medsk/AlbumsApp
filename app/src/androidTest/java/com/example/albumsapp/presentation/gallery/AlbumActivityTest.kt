package com.example.albumsapp.presentation.gallery

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.example.albumsapp.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 *Created by haskhiri on 18/10/2021
 */
@RunWith(AndroidJUnit4ClassRunner::class)
class AlbumActivityTest {

    @get:Rule
    var activityRule = ActivityTestRule(AlbumsActivity::class.java,false)

    @Test
    fun container_ISDisplayed() {
        onView(withId(R.id.frame_layout)).check(matches(isDisplayed()))
    }


}