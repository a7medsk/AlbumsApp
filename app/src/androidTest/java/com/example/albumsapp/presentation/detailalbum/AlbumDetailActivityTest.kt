package com.example.albumsapp.presentation.detailalbum

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.example.albumsapp.R
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 *Created by haskhiri on 18/10/2021
 */


@RunWith(AndroidJUnit4ClassRunner::class)
class AlbumDetailActivityTest {

    val STRING_TO_BE_TYPED = "Espresso"

    @get:Rule
    var activityRule = ActivityTestRule(AlbumDetailActivity::class.java)



    @Test
    fun isToolbarImageDisplayed(){
        Espresso.onView(withId(R.id.detail_toolbar_image_view))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }






}