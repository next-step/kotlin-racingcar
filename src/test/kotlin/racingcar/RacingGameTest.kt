package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.fuelproviders.FuelProvider
import racingcar.inputviews.GameInput

class FixedFuelProvider : FuelProvider {
    override fun getFuel(): Int {
        return 9
    }
}

class RacingGameTest {
    @Test
    fun `게임을 run 했을 때 input 의 numberOfCars 만큼의 Car 객체를 리턴 한다`() {
        val input = GameInput(5, 1)

        val gameResult = RacingGame(FixedFuelProvider()).run(input)

        assertThat(gameResult.cars).hasSize(5)
    }

    @Test
    fun `게임을 run 했을 때 리턴된 Car 들은 numberOfRounds 만큼의 currentPosition 값을 가진다`() {
        val input = GameInput(5, 3)

        val gameResult = RacingGame(FixedFuelProvider()).run(input)

        assertThat(gameResult.cars).allMatch { it.currentPosition == 3 }
    }
}
