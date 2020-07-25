package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarsTest {
    @Test
    fun findWinner() {
        val cars = Cars(listOf(
            Car("pobi", 4),
            Car("crong", 3),
            Car("honux", 4),
            Car("jk", 2)
        ))
        val winners = cars.findWinners()
        assertThat(winners).isEqualTo(
            Winners(listOf(
                Car("pobi", 4),
                Car("honux", 4)
            )))
    }
}
