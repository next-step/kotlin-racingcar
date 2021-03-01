package step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class OperatorTest {

    private val operator = Operator()

    @ParameterizedTest
    @MethodSource("parameterProvider")
    fun `사칙연산`(number1: Int, number2: Int, operatorString: String, result: Int) {
        assertThat(operator.operate(number1, number2, operatorString)).isEqualTo(result)
    }

    companion object {
        @JvmStatic
        fun parameterProvider(): Stream<Arguments> {
            return Stream.of(
                arguments(40, 20, "+", 60),
                arguments(40, 20, "-", 20),
                arguments(40, 20, "*", 800),
                arguments(40, 20, "/", 2)
            )
        }
    }
}
