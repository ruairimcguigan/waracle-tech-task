package com.waracle.techtask.interactors

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

@OptIn(ExperimentalCoroutinesApi::class)
class GetCakesInteractorImplTest {

    private val repo: com.waracle.techtask.repo.Repository = mock()

    @Test
    fun `getCakeInteractor calls repo fetchCakes()`() = runTest {
        // when
        GetCakesInteractorImpl(repo).invoke()

        // then
        verify(repo).fetchCakes()
    }
}
