package racingcar

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import racingcar.domain.Car

class CarTest {

    @Test
    fun `자동차 이동`() {
        val carName = "자동차1"

        assertTrue(Car(carName).move(true) == 1)
    }

    @Test
    fun `각 자동차에 이름을 부여할 수 있다`() {
        val carName = "자동차1"

        assertTrue(Car(carName).name.equals(carName, false))
    }

    @Test
    fun `자동차 이름은 5자를 초과할 수 없다`() {
        val carName = "자동차123"

        assertThrows(IllegalArgumentException::class.java) {
            Car(carName)
        }
    }
}
