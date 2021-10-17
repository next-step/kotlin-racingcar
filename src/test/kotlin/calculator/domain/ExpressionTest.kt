package calculator.domain

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class ExpressionTest {

    @ParameterizedTest
    @NullAndEmptySource
    fun `null 또는 빈문자열을 입력값으로 사용하면 예외를 발생시킨다`(input: String?) {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Expression.validate(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 $ 3 + 4", "k + 2 ! 4"])
    fun `사칙연산 기호 및 숫자를 제외한 문자열을 입력값으로 사용하면 예외를 발생시킨다`(input: String?) {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Expression.validate(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 + 3", "2 - 4", "3 * 5", "5 / 5"])
    fun `숫자와 사칙연산 기호를 문자열로 입력값을 사용하면 올바른 식으로 판단한다`(input: String?) {
        assertThat(Expression.validate(input)).isEqualTo(input)
    }
}
