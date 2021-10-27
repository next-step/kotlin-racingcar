package racing.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingRoundsTest {
    @Test
    fun `라운드 갯수가 0인 테스트`() {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { RacingRounds.make(0) }
            .withMessage("양수만 가능합니다.")
    }

    @Test
    fun `라운드 정상 테스트`() {
        val cars = Cars.make(carNames = listOf("a", "b", "c"))
        val cars1 = Cars.make(carNames = listOf("a", "b", "c"))
        val pedal = Pedal(0)
        val roundResults = listOf(cars1.goForward(pedal), cars1.goForward(pedal))
        val gameResult = GameResult(roundResults, cars1.getWinners())
        assertThat(RacingRounds.make(2).raceDuringCountGivenByUser(cars = cars, pedal = pedal))
            .isEqualTo(gameResult)
    }
}
