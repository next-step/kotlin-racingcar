package racingcar.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.model.Car
import racingcar.model.Position
import racingcar.view.InputView.CAR_NAME_DELIMITER

internal class RacingGameTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 5, 10, 20])
    internal fun `자동차가 N대 생성된다`(carCount: Int) {
        val racingGame = RacingGame.of(carCount)
        assertThat(racingGame.cars.size).isEqualTo(carCount)
    }

    @Test
    internal fun `자동차 목록을 입력받는다`() {
        val carNames = "pobi,crong,honux".split(CAR_NAME_DELIMITER)

        val racingGame = RacingGame.of(carNames)

        val carNameArray = carNames.toTypedArray()
        val carNameArrayInRacingGame = racingGame.cars.map { it.name }.toTypedArray()
        assertThat(carNameArray contentEquals carNameArrayInRacingGame).isTrue
    }

    @ParameterizedTest
    @ValueSource(strings = ["", ",a,b", "a,,b", "a,b,"])
    internal fun `자동차 목록에 공백이나 빈 이름이 포함되면 안된다`(delimitedCarNames: String) {
        val carNames = delimitedCarNames.split(CAR_NAME_DELIMITER)
        assertThrows<IllegalArgumentException> { RacingGame.of(carNames) }
    }

    @Test
    internal fun `우승자를 선정한다`() {
        val winner = Car("win", Position(10))
        val loser = Car("lose", Position(9))
        val cars = listOf(winner, loser)
        val racingGame = RacingGame(cars)

        val winners = racingGame.winners()

        assertThat(winners.size).isEqualTo(1)
        assertThat(winners.first().name).isEqualTo(winner.name)
    }

    @Test
    internal fun `우승자가 2명 이상일 경우`() {
        val p1 = Car("pobi", Position(10))
        val p2 = Car("crong", Position(10))
        val p3 = Car("honux", Position(10))
        val cars = listOf(p1, p2, p3)

        val winners = RacingGame(cars).winners()

        assertThat(winners.toTypedArray() contentEquals cars.toTypedArray())
    }
}
