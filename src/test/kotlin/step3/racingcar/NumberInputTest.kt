package step3.racingcar

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource

class NumberInputTest {
    @Test
    fun `숫자인 문자열을 받으면 int로 변환한다`() {
        val intInput = "4"

        assertThat(InputParser.toInt(intInput)).isEqualTo(4)
        assertThat(InputParser.toInt(intInput)).isInstanceOf(Integer::class.java)
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = ["문자", " ", "\t"])
    fun `숫자가 아닌 문자열을 입력 받으면 에러를 발생시킨다`(value: String?) {
        assertThatThrownBy { InputParser.toInt(value) }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
