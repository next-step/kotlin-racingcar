package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

internal class CarTest : BehaviorSpec({
    Given("MoveType 조건에 따라 자동차는") {
        val id = 0
        val position = 0

        When("전진 가능한 상태라면") {
            val car = Car(id = id, currentPosition = position, name = "car1")
            val movingCar = car.move(FakeAlwaysMoveStrategy())
            Then("전진한다.") {
                movingCar.currentPosition shouldBe position + 1
            }
        }

        When("전진 불가능 상태라면") {
            val car = Car(id = id, currentPosition = position, name = "car2")
            val movingCar = car.move(FakeAlwaysNotMoveStrategy())
            Then("전진하지 않는다.") {
                movingCar.currentPosition shouldBe position
            }
        }
    }
})

class FakeAlwaysMoveStrategy : MoveStrategy {
    override fun isPossibleMove(): Boolean = true

    override fun getDistance(): Int = 1
}

class FakeAlwaysNotMoveStrategy : MoveStrategy {
    override fun isPossibleMove(): Boolean = false

    override fun getDistance(): Int = 1
}
