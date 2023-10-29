package racingcar.domain

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe

class RacingCarTest : ExpectSpec({

    context("자동차에게 FORWARD 방향을 주면") {
        val gameRule = FakeGameRule(MovingDirection.FORWARD)
        val racingCar = RacingCar(Position(0))

        expect("자동차의 포지션은 1 증가한다.") {
            racingCar.move(gameRule.getMovingDirection())
            racingCar.position shouldBe Position(1)
        }
    }

    context("자동차에게 STOP 방향을 주면") {
        val gameRule = FakeGameRule(MovingDirection.STOP)
        val racingCar = RacingCar(Position(0))

        expect("자동차의 포지션은 증가하지 않는다.") {
            racingCar.move(gameRule.getMovingDirection())
            racingCar.position shouldBe Position(0)
        }
    }
})
