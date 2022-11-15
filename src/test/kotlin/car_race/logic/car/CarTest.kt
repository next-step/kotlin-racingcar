package car_race.logic.car

import car_race.logic.system.MovingSystem
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

/**
 * @see Car
 */
class CarTest : FunSpec({
    context("Car 단위 테스트") {
        val defaultCarName = CarName("기본 차")
        val defaultPositionValue = 0
        val defaultPosition = CarPosition(defaultPositionValue)
        val car = Car(defaultCarName, defaultPosition)

        test("fun getPosition(): 현재 위치를 반환한다.") {
            car.getPosition() shouldBe defaultPosition
        }

        test("fun nextRound(): movingSystem.isMove()가 true 면 한 칸 움직인다") {
            val alwaysTrueSystem = object : MovingSystem {
                override fun canMove() = true
            }

            car.nextRound(alwaysTrueSystem)
            car.getPosition().getValue() shouldBe defaultPositionValue + 1
        }

        test("fun nextRound(): movingSystem.isMove()가 false 면 움직이지 않는다") {
            val alwaysFalseSystem = object : MovingSystem {
                override fun canMove() = false
            }

            car.nextRound(alwaysFalseSystem)
            car.getPosition().getValue() shouldBe defaultPositionValue
        }
    }
})
