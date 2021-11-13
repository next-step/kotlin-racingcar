package racingcar.communication

import racingcar.domain.racing.FinalLab
import racingcar.communication.input.Input
import racingcar.communication.output.Output

object ControlTower {
    fun decideRacingLabs(input: Input, output: Output): FinalLab {
        output.finalLab()
        return FinalLab(value = input.finalLab())
    }
}
