package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockkObject
import io.mockk.unmockkAll

internal class CarTest : BehaviorSpec({
    Given("MoveType 조건에 따라 자동차는") {
        val id = 0
        val position = 0
        mockkObject(MoveType)
        When("전진 가능한 상태라면") {
            val car = Car(id = id, _currentPosition = position)
            every { MoveType.isPossibleMove(any()) } returns true
            car.move(MoveType.DEFAULT)
            Then("전진한다.") {
                car.currentPosition shouldBe position + MoveType.DEFAULT.movePosition
            }
        }

        When("전진 불가능 상태라면") {
            val car = Car(id = id, _currentPosition = position)
            every { MoveType.isPossibleMove(any()) } returns false
            car.move(MoveType.DEFAULT)
            Then("전진하지 않는다.") {
                car.currentPosition shouldBe position
            }
        }
        unmockkAll()
    }
})
