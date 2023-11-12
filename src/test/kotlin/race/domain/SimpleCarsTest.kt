package race.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import race.domain.SimpleCar.Companion.MOVE_THRESHOLD

class SimpleCarsTest {
    private val makeStay = object : NumberGenerator {
        override fun generate() = 0
    }
    private val makeMove = object : NumberGenerator {
        override fun generate() = MOVE_THRESHOLD
    }

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

    @Test
    fun `보유한 모든 자동차에 대해 전진을 시도한다`() {
        val car1 = SimpleCar(CarName("car1"), 0)
        val car2 = SimpleCar(CarName("car2"), 0)
        val simpleCars = SimpleCars(listOf(car1, car2))

        simpleCars.moveAll(makeStay)
        assertThat(car1.location).isEqualTo(0)
        assertThat(car2.location).isEqualTo(0)

        simpleCars.moveAll(makeMove)
        assertThat(car1.location).isEqualTo(1)
        assertThat(car2.location).isEqualTo(1)
    }
}
