package racingcar

import domain.Car
import domain.Winner
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinnerTest {

    @Test
    fun `우승자 확인`() {
        val cars = listOf(Car("A") { 5 }, Car("B") { 0 })
        assertThat(Winner(cars).getWinner()[0].name).isEqualTo("A")
    }

    @Test
    fun `우승자는 한 명 이상일 수 있다`() {
        val cars = listOf(Car("A") { 5 }, Car("B") { 6 }, Car("C") { 9 })

        cars[0].move()
        cars[1].move()
        cars[2].move()

        assertThat(Winner(cars).getWinner().size).isEqualTo(3)
    }
}
