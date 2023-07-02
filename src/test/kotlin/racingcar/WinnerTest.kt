package racingcar

import domain.Car
import domain.Winner
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinnerTest {

    @Test
    fun `우승자 확인`() {
        val carA = Car("A")
        val carB = Car("B")
        carA.move(5)
        carB.move(2)
        val cars = listOf(carA, carB)
        assertThat(Winner(cars).getWinner()[0].name).isEqualTo("A")
    }

    @Test
    fun `우승자는 한 명 이상일 수 있다`() {
        val cars = listOf(Car("A"), Car("B"), Car("C"))

        cars[0].move(5)
        cars[1].move(6)
        cars[2].move(8)

        assertThat(Winner(cars).getWinner().size).isEqualTo(3)
    }
}
