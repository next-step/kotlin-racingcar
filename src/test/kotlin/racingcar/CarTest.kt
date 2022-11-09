package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.unmockkAll

internal class CarTest : BehaviorSpec({
    Given("MoveType 조건에 따라 자동차는") {
        val id = 0
        val position = 0
        val moveStrategy = mockk<RandomMoveStrategy>()

        When("전진 가능한 상태라면") {
            val car = Car(id = id, currentPosition = position)
            every { moveStrategy.isPossibleMove() } returns true
            every { moveStrategy.getDistance() } returns 1
            car.move(moveStrategy)
            Then("전진한다.") {
                car.currentPosition shouldBe position + 1
            }
        }

        When("전진 불가능 상태라면") {
            val car = Car(id = id, currentPosition = position)
            every { moveStrategy.isPossibleMove() } returns false
            every { moveStrategy.getDistance() } returns 1
            car.move(moveStrategy)
            Then("전진하지 않는다.") {
                car.currentPosition shouldBe position
            }
        }
        unmockkAll()
    }
})
