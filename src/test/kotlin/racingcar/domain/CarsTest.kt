package racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.Car.Companion.MOVE_THRESHOLD
import racingcar.domain.Car.Companion.START_POSITION
import racingcar.domain.Car.Companion.STEP
import racingcar.util.OrderNumberGenerator

class CarsTest : BehaviorSpec({
    given("moveAll 메소드") {
        val carCount = 2
        val cars = Cars(OrderNumberGenerator(MOVE_THRESHOLD - 1, MOVE_THRESHOLD), carCount)
        `when`("생성되는 숫자가 다르면") {
            then("전진여부가 달라진다") {
                cars.moveAll()
                cars.first().getPosition() shouldBe START_POSITION
                cars.last().getPosition() shouldBe START_POSITION + STEP
            }
        }
    }
})
