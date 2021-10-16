package racingcar.mock

import racingcar.RacingCarForwardCondition

class TrueRacingCarForwardCondition : RacingCarForwardCondition {

    override fun canForward(): Boolean = true
}
