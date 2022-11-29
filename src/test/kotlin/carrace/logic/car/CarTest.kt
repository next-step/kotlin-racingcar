package carrace.logic.car

import carrace.logic.system.MovingSystem
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

/**
 * @see Car
 */
internal class CarTest : FunSpec({
    context("Car 단위 테스트") {
        val defaultCarName = CarName("기본 차")
        val defaultPositionValue = 0
        val car = Car(defaultCarName)

        test("fun nextRound(): movingSystem.isMove()가 true 면 한 칸 움직인다") {
            val alwaysTrueSystem = object : MovingSystem {
                override fun canMove() = true
            }

            val nextRoundCar = car.nextRound(alwaysTrueSystem)
            nextRoundCar.carPosition.position shouldBe defaultPositionValue + 1
        }

        test("fun nextRound(): movingSystem.isMove()가 false 면 움직이지 않는다") {
            val alwaysFalseSystem = object : MovingSystem {
                override fun canMove() = false
            }

            val nextRoundCar = car.nextRound(alwaysFalseSystem)
            nextRoundCar.carPosition.position shouldBe defaultPositionValue
        }
    }
})
