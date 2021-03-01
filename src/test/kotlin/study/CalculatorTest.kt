package study

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import study.racingcar.step2.Calculator
import study.racingcar.step2.operation.AbstractCalculation
import study.racingcar.step2.operation.DivisionCalculation
import study.racingcar.step2.operation.MinusCalculation
import study.racingcar.step2.operation.MultiplicationCalculation
import study.racingcar.step2.operation.PlusCalculation
import java.util.stream.Stream

class CalculatorTest {

    @Test
    fun `예외 Test`() {
        assertThrows<IllegalArgumentException> {
            PlusCalculation().calculate("", "2")
        }
    }

    @ParameterizedTest
    @MethodSource("argumentsByCalculationAndExpressionAndResult")
    fun `단위 클래스 Test2`(calculation: AbstractCalculation, leftValue: String, rightValue: String, result: Int) {
        Assertions.assertThat(calculation.calculate(leftValue, rightValue)).isEqualTo(result)
    }

    @ParameterizedTest
    @MethodSource("argumentsByExpressionAndResult")
    fun `문자열 계산식 Test`(expression: String, result: Int) {
        Assertions.assertThat(Calculator(expression).calculation()).isEqualTo(result)
    }

    companion object {
        @JvmStatic private fun argumentsByCalculationAndExpressionAndResult(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(PlusCalculation(), "1", "2", 3),
                Arguments.of(MinusCalculation(), "5", "2", 3),
                Arguments.of(DivisionCalculation(), "4", "2", 2),
                Arguments.of(MultiplicationCalculation(), "4", "2", 8)
            )
        }

        @JvmStatic private fun argumentsByExpressionAndResult(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("1 + 2", 3),
                Arguments.of("1 - 2", -1),
                Arguments.of("10 / 2", 5),
                Arguments.of("5 * 2", 10),
                Arguments.of("2 + 3 * 4 / 2", 10)
            )
        }
    }
}
