package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WinnerTest {

    @Test
    fun `우승자 테스트`() {
        val values = Cars(listOf(Car("a", 2), Car("b", 1), Car("c", 1)))
        val winner = Winner(values.cars)

        assertThat(winner.winners.contains("a"))
    }

    @Test
    fun `우승자 테스트 여러명`() {
        val values = Cars(listOf(Car("a", 2), Car("b", 2), Car("c", 1)))
        val winner = Winner(values.cars)

        assertThat(winner.winners.containsAll(listOf("a", "b")))
    }
}
