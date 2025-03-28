@file:Suppress("ktlint:standard:no-wildcard-imports")

package carracing.game.controller

import carracing.game.domain.CarRacingModel
import carracing.game.domain.data.Race
import carracing.game.view.CarRacingView
import carracing.game.view.ErrorView
import carracing.game.view.InputView
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.kotlin.*

@OptIn(ExperimentalCoroutinesApi::class)
class CarRacingControllerTest {
    private val scope = TestScope(StandardTestDispatcher())
    private val inputView = mock<InputView>()
    private val errorView = mock<ErrorView>()
    private val carRacingView = mock<CarRacingView>()
    private val model = mock<CarRacingModel> { on { getRaceFlow() } doReturn emptyFlow() }

    private lateinit var controller: CarRacingController

    @BeforeEach
    fun init() {
        controller =
            CarRacingController(
                inputView = inputView,
                errorView = errorView,
                carRacingView = carRacingView,
                model = model,
                scope = scope,
            )
    }

    @Test
    fun `when start game is invoked should ask user for race parameters`() {
        whenever(inputView.inquireCarsAmount()).thenReturn("5")
        whenever(inputView.inquireRoundsAmount()).thenReturn("4")

        controller.startGame()

        verify(inputView).inquireCarsAmount()
        verify(inputView).inquireRoundsAmount()
    }

    @Test
    fun `when cars amount is incorrect should print error and ask again`() {
        val exception = IllegalArgumentException("Message")
        whenever(inputView.inquireCarsAmount()).thenReturn("-1")
        whenever(model.assignCarsAmount(any())).thenThrow(exception).doAnswer { }

        controller.startGame()

        verify(errorView).printError("Message")
        verify(inputView, times(2)).inquireCarsAmount()
    }

    @Test
    fun `when rounds amount is incorrect should print error and ask again`() {
        val exception = IllegalArgumentException("Message")
        whenever(inputView.inquireCarsAmount()).thenReturn("5")
        whenever(inputView.inquireRoundsAmount()).thenReturn("-1")
        whenever(model.assignRoundsAmount(any())).thenThrow(exception).doAnswer { }

        controller.startGame()

        verify(errorView).printError("Message")
        verify(inputView, times(2)).inquireRoundsAmount()
    }

    @Test
    fun `when parameters are set should start the race and show current state`() =
        runTest(scope.testScheduler) {
            val race = Race(cars = emptyList())
            val raceFlow = MutableStateFlow(race)
            whenever(inputView.inquireCarsAmount()).thenReturn("5")
            whenever(inputView.inquireRoundsAmount()).thenReturn("4")
            whenever(model.getRaceFlow()).thenReturn(raceFlow)

            controller.startGame()
            advanceUntilIdle()

            raceFlow.emit(Race(round = 1, cars = emptyList()))
            advanceUntilIdle()
            raceFlow.emit(Race(round = 2, cars = emptyList()))
            advanceUntilIdle()

            verify(carRacingView, times(3)).printCurrentRaceState(any())
        }

    @Test
    fun `when parameters are not set should print error and ask parameters again`() =
        runTest(scope.testScheduler) {
            val exception = IllegalArgumentException("Message")
            whenever(inputView.inquireCarsAmount()).thenReturn("5")
            whenever(inputView.inquireRoundsAmount()).thenReturn("4")
            whenever(model.getRaceFlow()).thenThrow(exception).thenReturn(emptyFlow())

            controller.startGame()
            advanceUntilIdle()

            verify(errorView).printError("Message")
            verify(inputView, times(2)).inquireCarsAmount()
            verify(inputView, times(2)).inquireRoundsAmount()
        }
}
