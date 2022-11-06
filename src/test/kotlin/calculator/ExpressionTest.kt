package calculator

import io.kotest.matchers.nulls.shouldNotBeNull
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource

internal class ExpressionTest {
    @ParameterizedTest
    @NullSource
    fun `입력값이 null인 경우`(operation: String?) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            Expression(operation)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "  "])
    fun `입력값이 공백인 경우`(operation: String) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            Expression(operation)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 * 2 + 2 - 10"])
    fun `정상적인 수식이 입력 된 경우`(operation: String) {
        Expression(operation).shouldNotBeNull()
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 * 2 + 2 - 10"])
    fun `정상적인 수식이 입력 되고 숫자, 연산자 분리를 성공한 경우`(operation: String) {
        val expression = Expression(operation)
        val (numbers, operators) = expression.partitionExpression()
        assertThat(numbers.isNotEmpty()).isTrue
        assertThat(operators.isNotEmpty()).isTrue
    }

    @ParameterizedTest
    @ValueSource(strings = [" 1 * 2 + 2 - 10"])
    fun `연산식 앞에 공백이 들어 간 경우`(operation: String) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            Expression(operation)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 * a + b - 10"])
    fun `숫자, 사칙연산 이외의 문자가 입력 된 경우`(operation: String) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            Expression(operation)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 * - 2 2 - 10"])
    fun `연산식 숫자, 연산자 순서가 맞지 않는 경우`(operation: String) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            Expression(operation)
        }
    }
}
