package racingcar.test

import racingcar.domain.FixedGameRule
import racingcar.domain.MovingDirection
import racingcar.domain.Nickname
import racingcar.domain.RacingCar

object RacingCarGenerator {

    fun create(nickname: Nickname = Nickname("nick"), direction: MovingDirection = MovingDirection.FORWARD): RacingCar {
        return RacingCar(nickname, FixedGameRule(direction))
    }
}
