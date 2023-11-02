package study.racingcar

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import racingcar.car.Car

class CarTest {
    @Test
    fun `자동차는 무조건 움직인다`() {
        // given
        val carNumber = 1
        val tryNumber = 1
        val car = Car(Car.MoveHistory(tryNumber), AlwaysMove())

        // when
        car.move()

        // then
        car.moveHistory.movements shouldBe listOf(1)
    }
}
