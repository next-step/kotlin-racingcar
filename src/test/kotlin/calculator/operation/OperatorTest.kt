package calculator.operation

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
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
}
