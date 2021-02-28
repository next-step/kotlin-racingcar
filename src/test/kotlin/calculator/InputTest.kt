package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InputTest {

    @Test
    fun `입력한 문자열을 받는다`() {
        val line = "5 / 3 - 2 * 4"
        val input = MockInput(line)
        val result = input.read()
        assertThat(result).isEqualTo(line)
    }
}
