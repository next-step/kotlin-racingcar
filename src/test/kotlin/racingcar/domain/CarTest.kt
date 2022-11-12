package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `자동차 이동 - 조건 참`() {
        val car = Car(CarName("pobi"))
        car.move { true }
        assertEquals(1, car.getDistance())
    }

    @Test
    fun `자동차 이동 - 조건 거짓`() {
        val car = Car(CarName("pobi"))
        car.move { false }
        assertEquals(0, car.getDistance())
    }

    @Test
    fun `자동차 위치 비교`() {
        val car1 = Car(CarName("pobi"))
        val car2 = Car(CarName("pobi"))
        car1.move { true }
        assertEquals(1, car1.compareTo(car2))
    }
}
