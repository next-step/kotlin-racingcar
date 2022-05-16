package racing

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racing.domain.Car
import racing.domain.RacingCars
import racing.domain.StaticPowerStrategy

private fun TestCar(name: String, position: Int = 0) =
    Car(name = name, powerStrategy = StaticPowerStrategy(power = 10), startPosition = position)

class RacingCarTest {

    @Test
    fun `차 이름이 5글자를 초과하면, IllegalArgumentException 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            val andy = TestCar("Andy")
            val bruce = TestCar("BrunoMars")

            RacingCars(listOf(andy, bruce))
        }
    }

    @Test
    fun `moveAll 호출 시 모든 차량이 1씩 이동한다`() {
        val andy = TestCar("Andy", 2)
        val bruce = TestCar("Bruce", 1)

        val racingCars = RacingCars(listOf(andy, bruce))

        racingCars.moveAll()

        Assertions.assertThat(andy.position).isEqualTo(3)
        Assertions.assertThat(bruce.position).isEqualTo(2)
    }

    @Test
    fun `가장 멀리 이동한 차량들을 승자로 한다`() {
        val andy = TestCar("Andy", 2)
        val bruce = TestCar("Bruce", 1)
        val clara = TestCar("Clara", 2)

        val winners = RacingCars(listOf(andy, bruce, clara)).findWinners()

        Assertions.assertThat(winners.carNames).isEqualTo(listOf("Andy", "Clara"))
    }
}
