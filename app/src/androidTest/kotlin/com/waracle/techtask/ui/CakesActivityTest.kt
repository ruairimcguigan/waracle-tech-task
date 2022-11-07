package com.waracle.techtask.ui

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import coil.Coil
import com.waracle.techtask.ext.ImageLoaderFake
import com.waracle.techtask.testmodels.androidFirstCake
import com.waracle.techtask.testmodels.androidSecondCake
import com.waracle.techtask.testmodels.androidThirdCake
import com.waracle.techtask.ui.theme.CakeImage
import com.waracle.techtask.ui.theme.CakeListItem
import com.waracle.techtask.ui.theme.CakesList
import com.waracle.techtask.ui.theme.ToolbarWithRefreshAction
import org.junit.Rule
import org.junit.Test
import com.waracle.techtask.R
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

class CakesActivityTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun CakeTitleAndDescIsDisplayedOnAllCakeCards() {
        val cakesList = listOf(androidFirstCake, androidSecondCake, androidThirdCake)
        composeTestRule.setContent {
            CakesList(cakes = cakesList)
        }

        cakesList.forEach { cake ->
            composeTestRule.onNodeWithText(cake.title).assertIsDisplayed()
            composeTestRule.onNodeWithText(cake.desc).assertIsDisplayed()
        }
    }

    @Test
    fun cakeTitleAndDescDisplayedOnACakeListCard() {
        composeTestRule.setContent {
            CakeListItem(androidFirstCake)
        }

        composeTestRule.onNodeWithText(androidFirstCake.title).assertIsDisplayed()
        composeTestRule.onNodeWithText(androidFirstCake.desc).assertIsDisplayed()
    }

    @Test
    fun cakeImageWithContentDescriptionIsDisplayedOnACakeListCard() {
        Coil.setImageLoader(ImageLoaderFake())

        composeTestRule.setContent {
            CakeImage(androidFirstCake.image)
        }

        composeTestRule.onNodeWithContentDescription("a cake")
    }

    @Test
    fun toolbarWithAppNameIsDisplayedOnScreen() {
        val onRefreshClick: () -> Unit = mock()

        composeTestRule.setContent {
            ToolbarWithRefreshAction(R.drawable.ic_refresh, {})
        }

        composeTestRule.onNodeWithText("Waracle Tech Task").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("click me to refresh").assertHasClickAction()
        composeTestRule.onNodeWithContentDescription("click me to refresh").performClick()
        verify(onRefreshClick, times(1))
    }
}
