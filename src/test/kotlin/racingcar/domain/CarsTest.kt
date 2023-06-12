package racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingcar.util.OrderNumberGenerator

class CarsTest : BehaviorSpec({
    given("moveAll 메소드") {
        val carCount = 2
        val cars = Cars.createCars(
            (0 until carCount).map { it.toString() },
            OrderNumberGenerator(Car.MOVE_THRESHOLD - 1, Car.MOVE_THRESHOLD),
        )
        `when`("생성되는 숫자가 다르면") {
            then("전진여부가 달라진다") {
                cars.moveAll()
                cars.first().getPosition() shouldBe Car.START_POSITION
                cars.last().getPosition() shouldBe Car.START_POSITION + Car.STEP
            }
        }
    }

    given("getWinner 메소드") {
        val carCount = 3
        val cars = Cars(
            (0 until carCount).map { it.toString() },
            OrderNumberGenerator(Car.MOVE_THRESHOLD, Car.MOVE_THRESHOLD - 1)
        )
        `when`("움직인 여부가 다르면") {
            then("승패가 정해진다") {
                cars.moveAll()
                cars.getWinners() shouldBe listOf(cars.first(), cars.last())
            }
        }
    }
})
