package racingcar.mock

import racingcar.RacingCarForwardCondition

class AlwaysForwardRacingCarForwardCondition : RacingCarForwardCondition {

    override fun canForward(): Boolean = true
}
