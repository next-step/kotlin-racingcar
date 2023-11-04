package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GameResultTest {

    @Test
    fun `차들 중 가장 멀리 위치한 차가 우승자가 된다`() {
        // given
        val firstCar = Car("car1", 2)
        val secondCar = Car("car2", 4)
        val gameResult = GameResult(listOf(RacingHistory(0, listOf(firstCar, secondCar))))

        // when
        val winner = gameResult.getWinners()

        // then
        assertThat(winner.size).isEqualTo(1)
        assertThat(winner.first().name).isEqualTo("car2")
        assertThat(winner.first().position).isEqualTo(4)
    }
}
