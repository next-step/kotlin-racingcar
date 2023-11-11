package race.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SimpleCarsTest {
    @Test
    fun `가장 멀리 이동한 자동차가 우승한다`() {
        val winner = SimpleCar(CarName("1st"), 100)
        val looser = SimpleCar(CarName("2nd"), 0)
        val simpleCars = SimpleCars(listOf(looser, winner))

        val winners = simpleCars.findWinners()
        assertThat(winners.size).isEqualTo(1)
        assertThat(winners.first()).isEqualTo(winner)
    }

    @Test
    fun `가장 멀리 이동한 자동차가 여럿일 경우 공동 우승한다`() {
        val car1 = SimpleCar(CarName("car1"), 100)
        val car2 = SimpleCar(CarName("car2"), 100)
        val simpleCars = SimpleCars(listOf(car1, car2))

        val winners = simpleCars.findWinners()
        assertThat(winners.size).isEqualTo(2)
    }
}
