package racingcar.mock

import racingcar.RacingCarForwardCondition

class AlwaysBackwardRacingCarForwardCondition : RacingCarForwardCondition {

    override fun canForward(): Boolean = false
}
