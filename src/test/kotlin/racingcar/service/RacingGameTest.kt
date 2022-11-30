package racingcar.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class RacingGameTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 5, 10, 20])
    internal fun `자동차가 N대 생성된다`(carCount: Int) {
        val racingGame = RacingGame.of(carCount)
        assertThat(racingGame.cars.size).isEqualTo(carCount)
    }

    @Test
    internal fun `자동차 목록을 입력받는다`() {
        val carNames = "pobi,crong,honux"

        val racingGame = RacingGame.of(carNames)

        val carNameArray = carNames.split(RacingGame.CAR_NAME_DELIMITER)
        val carNameArrayInRacingGame = racingGame.cars.map { it.name.value }
        assertThat(carNameArray).containsExactlyInAnyOrderElementsOf(carNameArrayInRacingGame)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", ",a,b", "a,,b", "a,b,"])
    internal fun `자동차 목록에 공백이나 빈 이름이 포함되면 안된다`(carNames: String) {
        assertThrows<IllegalArgumentException> { RacingGame.of(carNames) }
    }
}
