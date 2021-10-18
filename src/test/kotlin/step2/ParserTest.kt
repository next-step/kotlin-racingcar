package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource

class ParserTest {
    private val parser = Parser(" ")
    private val expected = listOf("1.1", "+", "2")

    @ParameterizedTest
    @ValueSource(strings = ["1.1 + 2"])
    fun `입력값 파싱 정상 케이스`(input: String) {
        val result = parser.parse(input)
        assertThat(result.size).isEqualTo(expected.size)
        result.forEachIndexed { index, value -> assertThat(value).isEqualTo(expected[index]) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1.1 ? 2", "4 ^* 3"])
    fun `사칙 연산 기호가 아닌 케이스`(input: String) {
        assertThatIllegalArgumentException().isThrownBy { parser.parse(input) }
            .withMessage("사칙연산 기호가 아닙니다.")
    }

    @ParameterizedTest
    @EmptySource
    fun `빈값인 케이스`(input: String) {
        assertThatIllegalArgumentException().isThrownBy { parser.parse(input) }
            .withMessage("입력값이 빈 공백 문자이면 안됩니다.")
    }

    @ParameterizedTest
    @NullSource
    fun `널값인 케이스`(input: String?) {
        assertThatIllegalArgumentException().isThrownBy { parser.parse(input) }
            .withMessage("입력값이 null이면 안됩니다.")
    }
}
