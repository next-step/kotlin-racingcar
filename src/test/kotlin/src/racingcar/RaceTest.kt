package src.racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import src.racingcar.domain.Car
import src.racingcar.domain.Race

class RaceTest {

    @Test
    fun `여러대의 차들은 움직일 수 있다`() {
        val car1 = StubCar()
        val cars = listOf(car1)

        val race = Race(cars).start()

        assertThat(race[0].moveCount).isEqualTo(1)
    }

    class StubCar : Car("test") {
        override fun move(carMoveNumber: Int): Int {
            return super.moveCount++
        }
    }
}
