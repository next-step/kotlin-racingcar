package study.racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RoundTest {

    @Test
    fun `입력받은 레이싱 횟수에 따라 라운드가 생성된다`() {
        // Given
        val actual = Round(1)

        // When

        // Then
        assertThat(actual.roundCount).isEqualTo(1)
    }

    @Test
    fun `입력된 라운드 카운트가 0이하인 경우 에러를 반환한다`() {

        assertThrows<IllegalArgumentException> {
            Round(0)
        }
    }
}
