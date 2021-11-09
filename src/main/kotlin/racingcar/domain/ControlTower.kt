package racingcar.domain

import racingcar.input.Input
import racingcar.output.Output

object ControlTower {
    fun decideRacingLabs(input: Input, output: Output): Int {
        output.finalLab()
        return input.endLab()
    }
}
