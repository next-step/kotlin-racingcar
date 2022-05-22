package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import racingcar.model.Car
import racingcar.model.CarName
import racingcar.model.Cars
import racingcar.model.MovingStrategy
import racingcar.model.RacingGame
import racingcar.model.TryNumber

internal class RacingGameTest {

    private val movingStrategy = MovingStrategy { true }

    @Test
    fun `자동차들과 수행할 횟수를 받아서 레이싱 게임을 진행한 후 결과를 반환한다`() {
        // given
        val tryNumber = TryNumber(5)
        val cars = Cars("sam" to 5, "kaka" to 2, "luci" to 4, "andy" to 5)
        val racingGame = RacingGame(tryNumber = tryNumber, cars = cars)

        // when
        val result = racingGame.startGame()

        // then : 모든 차량이 5칸씩 전진 함
        val actualCars = result.results.last().cars
        val actualWinnerCars = result.winners
        val expectedCars = Cars("sam" to 10, "kaka" to 7, "luci" to 9, "andy" to 10)
        val expectedWinnerCars = Cars("sam" to 10, "andy" to 10)

        assertAll(
            { assertThat(actualCars).isEqualTo(expectedCars) },
            { assertThat(actualWinnerCars).isEqualTo(expectedWinnerCars) }
        )
    }

    private fun Cars(vararg nameToPositions: Pair<String, Int>): Cars = nameToPositions
        .map { (name, position) -> Car(CarName(name), position, movingStrategy) }
        .let(::Cars)
}
