package racingcar.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class CarTest {
    val testCondition = DriveCondition { true }
    val startDistance: Int = 1
    @Test
    fun `자동차는 조건에 맞으면 전진할 수 있다`() {
        val car = Car(1, testCondition)
        car.drive(1)
        Assertions.assertThat(car.distance).isEqualTo(startDistance + 1)
    }

    @Test
    fun `자동차는 조건에 맞지 않으면 전진할 수 있다`() {
        val car = Car(1, testCondition)
        car.drive(2)
        Assertions.assertThat(car.distance).isEqualTo(startDistance)
    }
}
