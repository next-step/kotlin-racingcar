package calculator.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class ExpressionTest {

    @ParameterizedTest
    @NullAndEmptySource
    fun `null 또는 빈문자열을 입력값으로 사용하면 예외를 발생시킨다`(input: String?) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Expression.validate(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 $ 3 + 4", "k + 2 ! 4"])
    fun `사칙연산 기호 및 숫자를 제외한 문자열을 입력값으로 사용하면 예외를 발생시킨다`(input: String?) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Expression.validate(input) }
    }
}