package step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

internal class RacingGameTest {
    @ParameterizedTest
    @ValueSource(ints = [0, 5])
    fun `play() 결과값으로 race 횟수와 일치하는 개수의 Result 반환한다`(raceCount: Int) {
        val carNames = "test1,test2"
        val racingGame = buildRacingGame(carNames, RandomRule())

        val results = racingGame.play(raceCount)

        assertThat(results.size).isEqualTo(raceCount)
        if (raceCount > 0) {
            assertThat(results[0].records.size).isEqualTo(2)
        }
    }

    private fun buildRacingGame(carNames: String, rule: Rule): RacingGame {
        val cars = Car.makeCars(carNames)
        return RacingGame(cars, rule)
    }

    @Test
    fun `Rule 을 만족시키는 회수 만큼 Result 의 position 이 증가한다`() {
        val carCount = "test"
        val raceCount = 3

        val mock = mock(Rule::class.java)
        `when`(mock.isSatisfied()).thenReturn(true)
        val racingGame = buildRacingGame(carCount, mock)

        val result = racingGame.play(raceCount)

        assertThat(result[raceCount - 1].records[0]).isEqualTo(raceCount)
    }
}
