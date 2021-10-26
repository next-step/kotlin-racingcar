package racing.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RoundTest {
    @Test
    fun `라운드 갯수가 0인 테스트`() {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { RacingRounds.make(0) }
            .withMessage("양수만 가능합니다.")
    }

    @Test
    fun `라운드 정상 테스트`() {
        val cars = Cars.make(carNames = listOf("a", "b", "c"))
        val pedal = Pedal(0)
        assertThat(RacingRounds.make(2).raceDuringCountGivenByUser(cars = cars, pedal = pedal))
            .isEqualTo(Array(2) { RoundResult(listOf(Pair("a", it + 1), Pair("b", it + 1), Pair("c", it + 1))) })
    }
}
