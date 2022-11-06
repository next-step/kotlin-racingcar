package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import racingcar.condition.RandomMoveCondition

internal class CarTest : BehaviorSpec({
    val randomMoveCondition = mockk<RandomMoveCondition>()

    Given("랜덤 조건으로 움직이는 차가") {
        val name = "테스트 차"
        val position = 0
        When("움직일 수 있는 조건이 true일 때 움직이려고 하면,") {
            val car = Car(name, position, listOf(randomMoveCondition))
            every { randomMoveCondition.available() } returns true
            val result = car.move()
            Then("앞으로 전진한다.") {
                result shouldBe position + Car.SPEED
            }
        }

        When("움직일 수 있는 조건이 false일 때 움직이려고 하면,") {
            every { randomMoveCondition.available() } returns false
            val car = Car(name, position, listOf(randomMoveCondition))
            val result = car.move()
            Then("정지해있다.") {
                result shouldBe position
            }
        }
    }
})
