package step2.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class OperatorTest {

    @DisplayName("Operator values() 기능 테스트")
    @ParameterizedTest(name = "연산자 : {0}, 결과 enum : {1}")
    @MethodSource("squares")
    fun values_test(sign: String, operator: Operator) {
        // given and when
        val actual = Operator.values(sign)

        // then
        assertThat(actual).isEqualTo(operator)
    }

    companion object {
        @JvmStatic
        fun squares() = listOf(
            Arguments.of("+", Operator.PLUS),
            Arguments.of("-", Operator.MINUS),
            Arguments.of("*", Operator.MULTIPLICATION),
            Arguments.of("/", Operator.DIVISION),
            Arguments.of("%", Operator.REMAINDER)
        )
    }
}
