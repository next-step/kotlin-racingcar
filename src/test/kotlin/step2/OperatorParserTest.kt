package step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import step2.module.CalculatorParser

class OperatorParserTest {

    @ParameterizedTest
    @ValueSource(strings = ["2 + 3 * 4 / 2"])
    fun `계산기의 입력값을 파싱 한다`(str: String) {

        val calculatorParser = CalculatorParser()

        assertThat(calculatorParser.parse(str).size).isEqualTo(7)
    }

    @ParameterizedTest
    @ValueSource(strings = ["2! + 3 * 4 / 2", "2 % 3 * 4 / 2"])
    fun `사칙연산의 기호가 아닐 경우`(str: String) {

        val calculatorParser = CalculatorParser()

        assertThrows<IllegalArgumentException> { calculatorParser.parse(str) }
    }

    @Test
    fun `입력값이 null이거나 빈 공백을 테스트 한다`() {

        val calculatorParser = CalculatorParser()

        // val inputNull = null
        // assertThrows<NullPointerException> { calculatorParser.parse(null) }
        val blank = ""
        assertThrows<IllegalArgumentException> { calculatorParser.parse(blank) }
    }
}
