package step4.racingcar.racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarRacingTest {

    @ParameterizedTest
    @ValueSource(ints = [3, 6])
    fun `우승자 확인 테스트`(input: Int) {
        val racers = listOf("molly", "jayce", "pug")
        val racingGame = CarRacing(racers, 0)
        racingGame.execute()
        racingGame.gameResult.cars.first().move(5)

        val winner = racingGame.getWinner()
        assertThat(winner).isEqualTo(listOf(racers.first()).joinToString())
    }

    @ParameterizedTest
    @ValueSource(ints = [3, 6])
    fun `우승자 여러명 테스트`(input: Int) {
        val racers = listOf("molly", "jayce", "pug")
        val racingGame = CarRacing(racers, 0)
        racingGame.execute()
        racingGame.gameResult.cars.forEach {
            it.move(input)
        }
        val winner = racingGame.getWinner()
        assertThat(winner).isEqualTo(racers.joinToString())
    }
}
