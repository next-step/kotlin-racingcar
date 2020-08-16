package racing.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `Car Add Test`() {
        val cars = listOf(Car("jane1", mutableListOf()), Car("jane2", mutableListOf()))
        for (car in cars) {
            car.saveResultOfTurn(1)
            car.saveResultOfTurn(1)
            car.saveResultOfTurn(1)
        }
        Assertions.assertThat(cars[0].takeRaceHistory(3)).isEqualTo(3)
        Assertions.assertThat(cars[1].takeRaceHistory(3)).isEqualTo(3)
    }
}
