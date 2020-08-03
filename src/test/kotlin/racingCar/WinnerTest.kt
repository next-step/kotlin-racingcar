package racingCar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingCar.domain.Car
import racingCar.domain.Winner

class WinnerTest {
    private lateinit var cars: List<Car>

    private fun setup() {
        cars = listOf(Car("A", 3), Car("B", 2), Car("C", 2))
    }

    @Test
    fun `get winner`() {
        setup()
        assertThat(Winner.getRacingWinner(cars)).isEqualTo(cars[0].name)
    }
}
