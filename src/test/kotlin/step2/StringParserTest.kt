package step2

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class StringParserTest {
    @ParameterizedTest
    @ValueSource(
        strings = [
            "1.1a + 12 + 3 / 4",
            "1.1a+12+3/4",
            " 1.1  a       + 1 2 +3 / 4 ",
            " 1 . 1a         + 1 2 + 3 /4 ",
        ]
    )
    fun `입력된 문자열로부터 공백을 제거하고 연산기호에만 공백을 추가한다`(string: String) {
        val expected = "1.1a + 12 + 3 / 4"
        assertThat(StringParser.parseByOperatorSymbols(string)).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "1.1a + 12 + 3 / 4",
            "1.1a+12+3/4",
            " 1.1  a       + 1 2 +3 / 4 ",
            " 1 . 1a         + 1 2 + 3 /4 ",
        ]
    )
    fun `입력된 문자열로부터 공백이 모두 제거되고 연산기호를 기준으로 분리된 문자열 리스트를 반환한다`(string: String) {
        val expected = listOf<String>("1.1a", "+", "12", "+", "3", "/", "4")
        assertThat(StringParser.listByOperatorSymbol(string)).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1.1a", "x"])
    fun `Double 로 변환할 수 없는 문자열의 경우에 대한 예외처리`(string: String) {
        Assertions.assertThatThrownBy {
            Calculator.calculate(string)
        }.hasMessageContaining(StringParser.NumberFormatExceptionErrorMessage)
    }
}
