package racingcar

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `각 자동차에 이름을 부여할 수 있다`() {
        val carName = "자동차1"

        Assertions.assertTrue(Car(carName).name.equals(carName, false))
    }

    @Test
    fun `자동차 이름은 5자를 초과할 수 없다`() {
        val carName = "자동차123"

        Assertions.assertThrows(IllegalArgumentException::class.java) {
            Car(carName)
        }
    }

    @Test
    fun `자동차 이름은 쉼표(,)를 기준으로 구분한다`() {
        val carNames = "자동차1,자동차2,자동차3"
        val tryCount = 1

        val racingHistory = RacingCar(carNames, tryCount).start(ForwardStrategy.CarForward)

        Assertions.assertTrue(racingHistory.keys.toList().size == carNames.split(",").size)
    }
}
