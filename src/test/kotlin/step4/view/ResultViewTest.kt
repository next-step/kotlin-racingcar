package step4.view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import step4.model.Car

class ResultViewTest {
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
