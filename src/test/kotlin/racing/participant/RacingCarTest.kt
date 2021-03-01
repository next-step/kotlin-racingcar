package racing.participant

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RacingCarTest {
    private val name = "cys"

    @Test
    fun `레이싱카가 움직이면 움직인 순간을 기록한다`() {
        //given
        val racingCar = racingCar()

        //when
        val history = racingCar.run()

        //then
        assertThat(history.name).isEqualTo(name)
        assertThat(history.position).isEqualTo(1)
    }

    @Test
    internal fun `레이싱카는 한칸씩 움직인다`() {
        //given
        val racingCar = racingCar()
        racingCar.run()

        //when
        val history = racingCar.run()

        //then
        assertThat(history.position).isEqualTo(2)
    }

    private fun racingCar(): RacingCar {
        val racer = Racer(name = name)
        return RacingCar(
            racer = racer,
            engine = InfinitePowerEngine()
        )
    }

    private class InfinitePowerEngine : Engine {

        override fun enoughEnergy(): Boolean {
            return true
        }
    }
}

