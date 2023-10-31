package study.car_racing

import car_racing.CarRacing
import car_racing.car.Car
import car_racing.move.AlwaysMove
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class CarRacingTest {
    @Test
    fun `자동차는 무조건 움직인다`() {
        // given
        val carNumber = 1
        val tryNumber = 1
        val car = Car(tryNumber, AlwaysMove())

        // when
        car.move()

        // then
        car.moveHistory shouldBe listOf(1)
    }

    @Test
    fun `자동차 게임을 한다`() {
        // given
        val carNumber = 1
        val tryNumber = 3
        val cars = MutableList(carNumber) { Car(tryNumber, AlwaysMove()) }

        // when
        CarRacing().start(tryNumber, cars)

        // then
        cars[0].moveHistory shouldBe listOf(1, 2, 3)
    }
}
