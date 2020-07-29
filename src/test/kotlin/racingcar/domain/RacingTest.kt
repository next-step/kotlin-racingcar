package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.strategy.FairStrategy

internal class RacingTest {
    companion object {
        const val TRY_COUNT = 5
    }

    private val racing = Racing(listOf("car1", "car2"), TRY_COUNT, FairStrategy())

    private fun testRace() {
        for (i in 1..TRY_COUNT) {
            racing.race()
        }
    }

    @Test
    fun race() {
        val actual = racing.race()
        assertThat(actual).isEqualTo("car1 : -\ncar2 : -\n")
    }

    @Test
    fun getWinner() {
        testRace()
        val winner = racing.getWinner()
        val actual = winner.all {
            it.isWinner(TRY_COUNT)
        }
        assertThat(actual).isTrue()
    }

    @Test
    fun isProgress() {
        assertThat(racing.isProgress()).isTrue()
    }
}
