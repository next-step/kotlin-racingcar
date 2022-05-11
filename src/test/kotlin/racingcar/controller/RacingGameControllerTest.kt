package racingcar.controller

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test
import racingcar.view.input.InputView
import racingcar.view.input.NumberAndSteps

internal class RacingGameControllerTest {

    @Test
    internal fun testForGameController() {

        val stepsToTry = 5
        val inputView = object : InputView<NumberAndSteps> {
            override fun showInputView() = NumberAndSteps(3, stepsToTry)
        }
        val gameBuilder = NumberAndStepsGameBuilder()

        val gameController = RacingGameController(
            inputView = inputView,
            gameBuilder = gameBuilder
        )

        gameController.executeGame()
        val racingGame = gameController.currentGame

        assertAll(
            { Assertions.assertThat(racingGame).isNotNull },
            { Assertions.assertThat(racingGame?.currentStep).isEqualTo(stepsToTry) },
            { Assertions.assertThat(racingGame?.isOver).isTrue }
        )
    }
}
