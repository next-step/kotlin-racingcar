package racingcar

import racingcar.view.component.CarNameInputComponent
import racingcar.view.component.RacingResultComponent
import racingcar.view.component.RoundInputComponent

object RacingGame {
    fun run() {
        CarNameInputComponent().render()
        RoundInputComponent().render()
        RacingResultComponent().render()
    }
}
