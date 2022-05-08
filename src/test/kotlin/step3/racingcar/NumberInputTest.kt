package step3.racingcar

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class NumberInputTest {
    @Test
    fun `횟수 n을 입력 받는다 n은 정수 int type`() {
        val intInput = "4"
        val stringInput = "문자"
        val nullInput = null
        val blinkInput = ""

        assertThat(InputParser.toInt(intInput)).isEqualTo(4)
        assertThatThrownBy { InputParser.toInt(stringInput) }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { InputParser.toInt(nullInput) }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { InputParser.toInt(blinkInput) }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
