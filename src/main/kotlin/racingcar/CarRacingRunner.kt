package racingcar

import racingcar.domain.CarRacingConfiguration
import racingcar.domain.CarRacingGame
import racingcar.view.CarRacingInputView

object CarRacingRunner {
    fun run() {
        val input = CarRacingInputView.getInputForStart()
        val configuration = CarRacingConfiguration.of(input)
        CarRacingGame.set(configuration.getCarRacingGameConfiguration())
    }
}
