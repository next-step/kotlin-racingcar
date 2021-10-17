package racingcar.mock

import racingcar.model.RacingCarForwardCondition

class AlwaysForwardRacingCarForwardCondition : RacingCarForwardCondition {

    override fun canForward(): Boolean = true
}
