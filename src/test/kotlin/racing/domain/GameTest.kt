package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class GameTest {

    @ParameterizedTest
    @CsvSource("1,3", "3,3", "5,3")
    fun `게임 초기화`(racingCarCount: Int, round: Int) {
        val game = Game(racingCarCount, round)
        assertThat(game.cars.size).isEqualTo(racingCarCount)
    }
}
