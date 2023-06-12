package calculator.operation

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

class OperatorTest {
    companion object {
        @JvmStatic
        fun testCases(): Stream<Arguments> = Stream.of(
            Arguments.of("+", PlusOperation::class.java),
            Arguments.of("-", MinusOperation::class.java),
            Arguments.of("*", MultiplyOperation::class.java),
            Arguments.of("/", DivideOperation::class.java)
        )
    }

    @ParameterizedTest(name = "[{index}] {0}")
    @MethodSource("testCases")
    fun `문자열에 대응 되는 연산자가 잘 생성되어지는지 테스트`(input: String, resultClass: Class<*>) {
        // given
        val leftOperation = MockOperator()
        val rightOperation = MockOperator()

        // when
        val result = Operator.getOperator(input, leftOperation, rightOperation)

        // then
        Assertions.assertThat(result).isInstanceOf(resultClass)
    }

    @ParameterizedTest
    @ValueSource(strings = ["+", "-", "*", "/"])
    fun `지원하는 연산자인지 파악 테스트`(input: String) {
        Assertions.assertThat(Operator.isOperator(input)).isTrue()
    }

    @Test
    fun `파라미터가 연산자가 아닐 경우`() {
        Assertions.assertThat(Operator.isOperator("23")).isFalse()
    }

    @Test
    fun `연산자 분리 테스트`() {
        // given
        val expression = "2+3/1*3"
        // when
        val result = Operator.splitOperators(expression)
        // then
        Assertions.assertThat(result).containsExactly("+", "/", "*")
    }

    @Test
    fun `피연산자 분리 테스트`() {
        // given
        val expression = "2+3-1*2"
        // when
        val result = Operator.splitOperands(expression)
        // then
        Assertions.assertThat(result).containsExactly("2", "3", "1", "2")
    }
}
