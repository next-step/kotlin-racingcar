package racingcar

import racingcar.component.CarNameInputComponent
import racingcar.component.RacingResultComponent
import racingcar.component.RoundInputComponent

object RacingGame {
    fun run() {
        CarNameInputComponent().render()
        RoundInputComponent().render()
        RacingResultComponent().render()
    }
}
