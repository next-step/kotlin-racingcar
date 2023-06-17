package study

import domain.Car
import domain.Winner
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinnerTest {

    @Test
    fun `우승자 확인`() {
        val cars = listOf(Car("A", 5), Car("B", 2))
        assertThat(Winner(cars).getWinner()).isEqualTo("A")
    }
}
