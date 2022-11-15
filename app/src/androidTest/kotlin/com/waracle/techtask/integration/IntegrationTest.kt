package com.waracle.techtask.integration

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.waracle.techtask.testmodels.firstSuccessfulResponse
import com.waracle.techtask.testmodels.secondSuccessfulResponse
import com.waracle.techtask.testmodels.successfulAndroidResponse1
import com.waracle.techtask.testmodels.successfulAndroidResponse2
import com.waracle.techtask.ui.CakesActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import javax.inject.Inject

@HiltAndroidTest
class IntegrationTest {

    @get:Rule(order = 1)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 2)
    val composeTestRule = createAndroidComposeRule<CakesActivity>()

    @Inject
    lateinit var mockWebServer: MockWebServer

    @Before
    fun init() {
        hiltRule.inject()
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun initialLoadingAndRefreshingListSuccess() {
        enqueueSuccessResponse(successfulAndroidResponse1)
        waitUntilVisibleWithText(firstSuccessfulResponse[1].title)
        enqueueSuccessResponse(successfulAndroidResponse2)
        refreshCakesList()
        waitUntilVisibleWithText(secondSuccessfulResponse[1].title)
    }

    @Test
    fun initialLoadingFail() {
        enqueue400ErrorResponse(successfulAndroidResponse1)
        waitUntilVisibleWithText("Failed to fetch cakes")
        composeTestRule.onAllNodes(isRoot()).printToLog("currentLabelExists")
        enqueue400ErrorResponse(successfulAndroidResponse1)
        refreshCakesList()
        waitUntilVisibleWithText("Failed to fetch cakes")
    }

    private fun enqueueSuccessResponse(responseJson: String) {
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .addHeader("Content-Type", "application/json; charset=utf-8")
                .setBody(responseJson)
        )
    }

    private fun enqueue400ErrorResponse(responseJson: String) {
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(400)
                .addHeader("Content-Type", "application/json; charset=utf-8")
                .setBody(responseJson)
        )
    }

    private fun waitUntilVisibleWithText(text: String) {
        composeTestRule.waitUntil {
            composeTestRule.onAllNodesWithText(text).fetchSemanticsNodes().isNotEmpty()
        }
    }

    private fun refreshCakesList() {
        val onRefreshClick: () -> Unit = mock()
        composeTestRule.onNodeWithContentDescription("click me to refresh").performClick()
        verify(onRefreshClick, times(1))
    }
}
