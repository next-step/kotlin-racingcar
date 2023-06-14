package racingcar

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.Car.Companion.DEFAULT_POSITION

class CarTest {
    @Test
    fun `Car의 기본 positon은 1이다`() {
        val car = Car()

        car.position shouldBe DEFAULT_POSITION
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `condition이 4 이상이면 Car의 position이 1 증가한다`(condition: Int) {
        val car = Car()
        car.move(condition)

        car.position shouldBe DEFAULT_POSITION + 1
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `condition이 4 미만이면 Car의 position은 변하지 않는다`(condition: Int) {
        val car = Car()
        car.move(condition)

        car.position shouldBe DEFAULT_POSITION
    }
}
