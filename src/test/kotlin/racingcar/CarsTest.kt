package racingcar

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import racingcar.strategy.ManualStrategy

class CarsTest {
    private val carNames = listOf("test1", "test2", "test3")

    @Test
    fun `condition이 true 이면 모든 Car의 position이 1 증가한다`() {
        val cars = Cars(
            carNames.map { Car(name = it, moveStrategy = ManualStrategy(true)) }
        )

        cars.moveAll().map { it.position } shouldBe listOf(2, 2, 2)
    }

    @Test
    fun `condition이 false 이면 모든 Car의 position은 그대로다`() {
        val cars = Cars(
            carNames.map { Car(name = it, moveStrategy = ManualStrategy(false)) }
        )

        cars.moveAll().map { it.position } shouldBe listOf(1, 1, 1)
    }
}
