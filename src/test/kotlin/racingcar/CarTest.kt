package racingcar

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.Car.Companion.DEFAULT_POSITION
import racingcar.strategy.ManualStrategy

class CarTest {
    @Test
    fun `Car의 기본 positon은 1이다`() {
        val name = "test1"
        val car = Car(name)

        car.position shouldBe DEFAULT_POSITION
    }

    @Test
    fun `condition이 true 이면 Car의 position이 1 증가한다`() {
        val name = "test1"
        val car = Car(name = name, moveStrategy = ManualStrategy(true))
        car.move()

        car.position shouldBe DEFAULT_POSITION + 1
    }

    @Test
    fun `condition이 false 이면 Car의 position은 변하지 않는다`() {
        val name = "test1"
        val car = Car(name = name, moveStrategy = ManualStrategy(false))
        car.move()

        car.position shouldBe DEFAULT_POSITION
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "test12"])
    fun `Car의 이름이 공백이거나 5자를 초과하면 예외가 발생한다`(invalidName: String) {
        shouldThrow<IllegalArgumentException> { Car(invalidName) }
    }
}
