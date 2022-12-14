package src.racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import src.racingcar.domain.Car
import src.racingcar.domain.Winner

class WinnerTest {

    @Test
    fun `레이싱 우승자를 찾을 수 있다`() {
        val car1 = Car("test1")
        val car2 = Car("test2")
        val car3 = Car("test3")
        val cars = listOf(car1, car2, car3)
        car1.move(0)
        car2.move(4)
        car3.move(4)

        val winners = Winner(cars).findWinners()

        assertThat(winners[0].name).isEqualTo("test2")
        assertThat(winners[1].name).isEqualTo("test3")
    }
}
