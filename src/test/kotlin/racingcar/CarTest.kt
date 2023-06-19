package racingcar

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import racingcar.Car.Companion.DEFAULT_POSITION
import racingcar.strategy.ManualStrategy

class CarTest {
    @Test
    fun `Car의 기본 positon은 1이다`() {
        val car = Car()

        car.position shouldBe DEFAULT_POSITION
    }

    @Test
    fun `condition이 true 이면 Car의 position이 1 증가한다`() {
        val car = Car(conditionGenerateStrategy = ManualStrategy(true))
        car.move()

        car.position shouldBe DEFAULT_POSITION + 1
    }

    @Test
    fun `condition이 false 이면 Car의 position은 변하지 않는다`() {
        val car = Car(conditionGenerateStrategy = ManualStrategy(false))
        car.move()

        car.position shouldBe DEFAULT_POSITION
    }
}
