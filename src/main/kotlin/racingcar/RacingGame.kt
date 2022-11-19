package racingcar

import racingcar.component.CarInputComponent
import racingcar.component.RacingResultComponent
import racingcar.component.RoundInputComponent

object RacingGame {
    fun run() {
        CarInputComponent().render()
        RoundInputComponent().render()
        RacingResultComponent().render()
    }
}
