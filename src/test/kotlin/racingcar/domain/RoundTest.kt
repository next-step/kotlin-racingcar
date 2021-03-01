package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class RoundTest {
    @Test
    fun `라운드는 실행될 수 있다`() {
        val dummyCars = emptyList<Car>()
        val round = Round(dummyCars)
        round.play()
    }

    @Test
    fun `라운드는 두번 이상 실행될 수 없다`() {
        // given
        val dummyCars = emptyList<Car>()
        val round = Round(dummyCars)
        val expectedMessage = "이미 진행된 라운드입니다"

        // when
        val result = assertThrows<IllegalStateException> {
            round.play()
            round.play()
        }

        // then
        assertThat(result.message).isEqualTo(expectedMessage)
    }
}
