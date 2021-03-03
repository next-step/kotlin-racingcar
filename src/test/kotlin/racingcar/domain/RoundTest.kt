package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class RoundTest {
    @Test
    fun `라운드는 기록할 수 있다`() {
        val dummyDistances = emptyList<Int>()
        val roundResult = Result(dummyDistances)
        val round = Round()
        round.recordResult(roundResult)
    }

    @Test
    fun `라운드는 두번 이상 기록하면 예외가 발생한다`() {
        // given
        val dummyDistances = emptyList<Int>()
        val roundResult = Result(dummyDistances)
        val round = Round()
        val expectedMessage = "이미 진행된 라운드입니다"

        // when
        val result = assertThrows<IllegalStateException> {
            round.recordResult(roundResult)
            round.recordResult(roundResult)
        }

        // then
        assertThat(result.message).isEqualTo(expectedMessage)
    }
}
