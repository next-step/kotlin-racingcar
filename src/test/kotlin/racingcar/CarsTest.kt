package racingcar

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import racingcar.strategy.ManualStrategy

class CarsTest {
    @Test
    fun `condition이 4 이상이면 모든 Car의 position이 1 증가한다`() {
        val manualStrategy = ManualStrategy(4)
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
    fun `condition이 4 미만이면 모든 Car의 position은 그대로다`() {
        val manualStrategy = ManualStrategy(0)
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
