package racingcar.test

import racingcar.domain.FakeGameRule
import racingcar.domain.MovingDirection
import racingcar.domain.Nickname
import racingcar.domain.RacingCar

object RacingCarGenerator {

    private val FORWARD_GAME_RULE = FakeGameRule(MovingDirection.FORWARD)
    private val STOP_GAME_RULE = FakeGameRule(MovingDirection.STOP)

    fun create(nickname: Nickname = Nickname("nick"), rule: FakeGameRule = FORWARD_GAME_RULE): RacingCar {
        return RacingCar(nickname, rule)
    }
}
