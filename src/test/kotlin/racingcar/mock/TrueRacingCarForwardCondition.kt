package racingcar.mock

import racingcar.RacingCarForwardCondition

class TrueRacingCarForwardCondition : RacingCarForwardCondition {

    override fun isForward(): Boolean = true
}
