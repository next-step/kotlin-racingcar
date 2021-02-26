package step2.ui

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class ConsoleInputKtTest {
    @Test
    fun `공백인지 확인한다`() {
        // given
        val string = " "

        // when

        // then
        assertThatThrownBy { string.checkBlank() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("공백을 입력할 수 없습니다.")
    }

    @Test
    fun `공백이 아니면 아무일도 일어나지 않는다`() {
        // given
        val string = "ㅁ"

        // when
        val result = string.checkBlank()

        // then
        assertThat(result).isEqualTo(string)
    }
}
