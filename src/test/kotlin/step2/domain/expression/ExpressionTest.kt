package step2.domain.expression

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ExpressionTest {

    @DisplayName("Expression 인스턴스 생성시 공백 검증 테스트")
    @ParameterizedTest(name = "연산자 : {0}")
    @ValueSource(strings = ["", " ", "     "])
    fun constructor_blank_fail_test(blank: String) {
        assertThatThrownBy { Expression(blank) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("연산식이 null 또는 공백입니다.")
    }

    @DisplayName("Expression 인스턴스 생성시 null 검증 테스트")
    @Test
    fun constructor_null_fail_test() {
        val nullString: String? = null
        assertThatThrownBy { Expression(nullString) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("연산식이 null 또는 공백입니다.")
    }

    @DisplayName("Expression 인스턴스 hashCode 및 equals 검증 테스트")
    @ParameterizedTest(name = "연산자 : {0}")
    @ValueSource(strings = ["1 + 1", "1 - 1", "1 * 1", "1 / 1", "1 % 1"])
    fun hash_and_equals_test(lawExpression: String) {
        val one = Expression(lawExpression)
        val other = Expression(lawExpression)

        assertAll(
            { assertThat(one).hasSameHashCodeAs(other) },
            { assertThat(one).isEqualTo(other) }
        )
    }

    @DisplayName("Expression 인스턴스 split() 테스트")
    @ParameterizedTest(name = "연산자 : {0}")
    @ValueSource(strings = ["1 + 1", "1 - 1", "1 * 1", "1 / 1", "1 % 1"])
    fun split_test(lawExpression: String) {
        val expected = lawExpression.split(" ")
        val expression = Expression(lawExpression)
        val actual = expression.split { target -> target.split(" ") }

        assertAll(
            { assertThat(actual).isEqualTo(expected) },
            { assertThat(actual).containsExactlyElementsOf(expected) },
        )
    }
}
