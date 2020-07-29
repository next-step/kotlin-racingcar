package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.strategy.FairStrategy

internal class RacingCarsTest {
    companion object {
        const val TRY_COUNT = 5
    }

    private val racingCars = RacingCars(listOf("car1", "car2"), FairStrategy())

    @BeforeEach
    fun setUp() {
        for (i in 1..TRY_COUNT) {
            racingCars.moveForwardAll()
        }
    }

    @Test
    fun getWinner() {
        val actual = racingCars.getWinner().all {
            it.isWinner(TRY_COUNT)
        }
        assertThat(actual).isTrue()
    }

    @Test
    fun testToString() {
        val actual = racingCars.toString()
        val symbol = "-".repeat(TRY_COUNT)
        assertThat(actual).isEqualTo("car1 : $symbol\ncar2 : $symbol\n")
    }
}
