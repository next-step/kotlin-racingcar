package step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class RacingGameTest {
    @ParameterizedTest
    @ValueSource(ints = [0, 5])
    fun `play() 결과값으로 Car 대수에 맞는 개수의 Result 반환한다`(carCount: Int) {
        val racingGame = buildRacingGame(carCount)

        val results = racingGame.play()

        assertThat(results.size).isEqualTo(carCount)
    }

    private fun buildRacingGame(carCount: Int): RacingGame {
        val cars = Car.makeCars(carCount)
        return RacingGame(cars, Rule(), 3)
    }
}
