package step4.view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import step4.Car

class ResultViewTest {
    @Test
    fun `visualize block test`() {
        val raceResult = listOf(0, 1, 1, 1, 0, 1)

        assertThat(ResultView.visualize(3, raceResult)).isEqualTo("--")
        assertThat(ResultView.visualize(6, raceResult)).isEqualTo("----")
    }

    @Test
    fun `sortedDescending test`() {
        val raceResult = listOf(5, 8, 32, 6)

        assertThat(raceResult.sortedDescending()).isEqualTo(listOf(32, 8, 6, 5))
    }

    @Test
    fun `sortedDescending with object test`() {
        val raceResult = listOf(
            Car("a", 5, mutableListOf()),
            Car("b", 6, mutableListOf()),
            Car("c", 7, mutableListOf()),
            Car("d", 7, mutableListOf()),
            Car("e", 5, mutableListOf())
        )

        assertThat(raceResult.sortedByDescending { car -> car.raceResult }).isEqualTo(
            listOf(
                Car("c", 7, mutableListOf()),
                Car("d", 7, mutableListOf()),
                Car("b", 6, mutableListOf()),
                Car("a", 5, mutableListOf()),
                Car("e", 5, mutableListOf())
            )
        )
    }

    @Test
    fun `noticeWinner test`() {
        val raceCars = listOf(
            Car("a", 5, mutableListOf()),
            Car("b", 6, mutableListOf()),
            Car("c", 7, mutableListOf()),
            Car("d", 7, mutableListOf()),
            Car("e", 5, mutableListOf())
        )

        assertThat(ResultView.noticeWinner(raceCars.sortedByDescending { car -> car.raceResult })).isEqualTo("c,d")
    }
}
