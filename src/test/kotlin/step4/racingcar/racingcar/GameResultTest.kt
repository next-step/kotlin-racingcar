package step4.racingcar.racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class GameResultTest {

    @Test
    fun `우승자 확인 테스트`() {
        val cars = listOf(Car("molly"), Car("jayce"), Car("pug"))
        cars.first().move(5)
        val gameResult = GameResult(cars, 1)
        val winner = gameResult.getWinners()
        Assertions.assertThat(winner).isEqualTo(listOf(cars.first().racerName))
    }

    @ParameterizedTest
    @ValueSource(ints = [3, 6])
    fun `우승자 여러명 테스트`(input: Int) {
        val cars = listOf(Car("molly"), Car("jayce"), Car("pug"))
        val gameResult = GameResult(cars, 1)
        val winner = gameResult.getWinners()
        Assertions.assertThat(winner).isEqualTo(cars.map { it.racerName })
    }
}
