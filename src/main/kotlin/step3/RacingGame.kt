package step3

import step3.component.CarInputComponent
import step3.component.RoundInputComponent

object RacingGame {
    fun run() {
        CarInputComponent().render()
        RoundInputComponent().render()
    }
}
