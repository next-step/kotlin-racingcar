package racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.strategy.FakeAlwaysMoveStrategy
import racingcar.domain.strategy.FakeAlwaysNotMoveStrategy

internal class CarTest : BehaviorSpec({
    Given("MoveType 조건에 따라 자동차는") {
        val position = 0
        val name = ParticipateCarName("car1")

        When("전진 가능한 상태라면") {
            val car = Car(currentPosition = position, participateCarName = name)
            val movingCar = car.move(FakeAlwaysMoveStrategy())
            Then("전진한다.") {
                movingCar.currentPosition shouldBe position + 1
            }
        }

        When("전진 불가능 상태라면") {
            val car = Car(currentPosition = position, participateCarName = name)
            val movingCar = car.move(FakeAlwaysNotMoveStrategy())
            Then("전진하지 않는다.") {
                movingCar.currentPosition shouldBe position
            }
        }
    }
})
