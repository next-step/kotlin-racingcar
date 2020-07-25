package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarsTest {
    @Test
    fun findWinner() {
        val cars = Cars(
            listOf(
                Car("pobi", 4),
                Car("crong", 3),
                Car("honux", 4),
                Car("jk", 2)
            )
        )
        val winners = cars.findWinners()
        assertThat(winners).isEqualTo(
            Winners(
                listOf(
                    Car("pobi", 4),
                    Car("honux", 4)
                )
            )
        )
    }

    @Test
    fun race() {
        val cars = Cars(
            listOf(
                Car("pobi"),
                Car("crong"),
                Car("honux"),
                Car("jk")
            )
        )
        for (x in 0..5) {
            cars.race()
            println(cars)
        }
    }
}
