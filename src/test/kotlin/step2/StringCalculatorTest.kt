package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

/**
 * 문자열 사칙 연산 계산기 테스트
 * Created by Jaesungchi on 2022.05.05..
 */

class StringCalculatorTest {
    @ParameterizedTest
    @CsvSource("2 + 3, 5", "5 - 2, 3", "5 * 3, 15", "5 + 3 / 4, 2", "2 + 3 * 4 / 2, 10")
    fun `계산기 정상 동작`(question: String, answer: Int) {
        val calculator = StringCalculator()
        assertThat(calculator.startCalculate(question)).isEqualTo(answer)
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException`(source: String?) {
        val calculator = StringCalculator()
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            calculator.startCalculate(source)
        }.withMessageMatching(ErrorMessage.IS_NULL_OR_BLANK)
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 [ 3", "2 $ 3"])
    fun `사칙연산 기호가 아닌 경우 IllegalArgumentException`(source: String) {
        val calculator = StringCalculator()
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            calculator.startCalculate(source)
        }.withMessageMatching(ErrorMessage.IS_NON_OPERATOR_CHARACTER)
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 *", "2 * 5 /"])
    fun `연산자와 피연산자 갯수 확인`(source: String) {
        val calculator = StringCalculator()
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            calculator.startCalculate(source)
        }.withMessageMatching(ErrorMessage.NOT_MATCH_OPERATORS_AND_OPERANDS)
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 * a", "2 * 5 / /"])
    fun `숫자 위치에 정상 숫자가 아닌 경우`(source: String) {
        val calculator = StringCalculator()
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            calculator.startCalculate(source)
        }.withMessageMatching(ErrorMessage.IS_NON_DIGIT_CHARACTER)
    }

    @Test
    fun `Operator는 연산자를 잘 찾아내는가`() {
        assertThat(Operator.of("+")).isEqualTo(Operator.PLUS)
        assertThat(Operator.of("-")).isEqualTo(Operator.MINUS)
        assertThat(Operator.of("/")).isEqualTo(Operator.DIVISION)
        assertThat(Operator.of("*")).isEqualTo(Operator.MULTIPLY)
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 / 0"])
    fun `0으로 나눌 수 없습니다`(source: String) {
        val calculator = StringCalculator()
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            calculator.startCalculate(source)
        }.withMessageMatching(ErrorMessage.CAN_NOT_DIVIDED_BY_ZERO)
    }
}
