package racingcar

import racingcar.domain.CarRacingInitialConfiguration
import racingcar.view.CarRacingInputView

object CarRacingRunner {
    fun run() {
        val input = CarRacingInputView.getInputForStart()
        val configuration = CarRacingInitialConfiguration.of(input)
    }
}
