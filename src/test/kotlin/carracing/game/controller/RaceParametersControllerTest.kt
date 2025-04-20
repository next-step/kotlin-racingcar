@file:Suppress("ktlint:standard:no-wildcard-imports")

package carracing.game.controller

import carracing.game.domain.InputValidator
import carracing.game.domain.data.Race
import carracing.game.view.CarRacingView
import carracing.game.view.ErrorView
import carracing.game.view.InputView
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.kotlin.*

class RaceParametersControllerTest {
    private val inputView = mock<InputView>()
    private val inputValidator =
        mock<InputValidator> {
            on { validateCarNames(any()) } doReturn listOf("car1", "car2")
            on { validateRoundsAmount(any()) } doReturn 2
        }
    private val errorView = mock<ErrorView>()
    private val carRacingView = mock<CarRacingView>()

    private lateinit var controller: RaceParametersController

    @BeforeEach
    fun init() {
        controller =
            RaceParametersController(
                inputView = inputView,
                inputValidator = inputValidator,
                errorView = errorView,
            )
    }

    @Test
    fun `when setRaceParameters is invoked should ask user for race parameters`() {
        whenever(inputView.inquireCarsNames()).thenReturn("5")
        whenever(inputView.inquireRoundsAmount()).thenReturn("4")

        controller.setRaceParameters()

        verify(inputView).inquireCarsNames()
        verify(inputView).inquireRoundsAmount()
    }

    @Test
    fun `when cars amount is incorrect should print error and ask again`() {
        val exception = IllegalArgumentException("Message")
        whenever(inputView.inquireCarsNames()).thenReturn("-1")
        whenever(inputValidator.validateCarNames(any())).thenThrow(exception).thenReturn(listOf("car", "car1"))

        controller.setRaceParameters()

        verify(errorView).printError("Message")
        verify(inputView, times(2)).inquireCarsNames()
    }

    @Test
    fun `when rounds amount is incorrect should print error and ask again`() {
        val exception = IllegalArgumentException("Message")
        whenever(inputView.inquireCarsNames()).thenReturn("5")
        whenever(inputView.inquireRoundsAmount()).thenReturn("-1")
        whenever(inputValidator.validateRoundsAmount(any())).thenThrow(exception).thenReturn(2)

        controller.setRaceParameters()

        verify(errorView).printError("Message")
        verify(inputView, times(2)).inquireRoundsAmount()
    }

    @Test
    fun `when parameters are set should return race`() {
        whenever(inputView.inquireCarsNames()).thenReturn("2")
        whenever(inputView.inquireRoundsAmount()).thenReturn("2")
        val expected = Race(carsNames = listOf("car1", "car2"), totalRounds = 2)
        val actual = controller.setRaceParameters()

        actual.cars shouldBe expected.cars
        actual.round shouldBe expected.round
    }
}
