package racingcar

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import racingcar.strategy.ManualStrategy

class CarsTest {
    @Test
    fun `condition이 true 이면 모든 Car의 position이 1 증가한다`() {
        val manualStrategy = ManualStrategy(true)
        val carsSize = 3
        val cars = Cars(
            List(carsSize) {
                val car = Car(conditionGenerateStrategy = manualStrategy)
                car
            }
        )

        cars.moveAll() shouldBe List(carsSize) { 2 }
    }

    @Test
    fun `condition이 false 이면 모든 Car의 position은 그대로다`() {
        val manualStrategy = ManualStrategy(false)
        val carsSize = 3
        val cars = Cars(
            List(carsSize) {
                val car = Car(conditionGenerateStrategy = manualStrategy)
                car
            }
        )

        cars.moveAll() shouldBe List(carsSize) { 1 }
    }
}
