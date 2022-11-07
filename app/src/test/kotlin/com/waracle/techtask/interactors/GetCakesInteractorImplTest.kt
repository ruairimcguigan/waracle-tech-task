package com.waracle.techtask.interactors

import com.waracle.techtask.repo.Repository
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class GetCakesInteractorImplTest {

    private val repo: Repository = mock()

    @Test
    fun `getCakeInteractor calls repo fetchCakes()`() = runTest {
        // when
        GetCakesInteractorImpl(repo).invoke()

        // then
        verify(repo).fetchCakes()
    }
}
