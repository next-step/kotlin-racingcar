package racingcar.mock

import racingcar.model.RacingCarForwardCondition

class AlwaysBackwardRacingCarForwardCondition : RacingCarForwardCondition {

    override fun canForward(): Boolean = false
}
