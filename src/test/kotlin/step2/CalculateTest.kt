package step2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import kotlin.random.Random

internal class CalculateTest {
    private val dut = Calculate()

    @ParameterizedTest
    @ValueSource(strings = ["", "  "])
    fun `empty string input throws IllegalArgumentException`(input: String) {
        assertThrows(IllegalArgumentException::class.java) { dut(input) }
    }

    @ParameterizedTest
    @MethodSource("makePlusOperationTestCase")
    fun `plus operation test with random value`(equation: String, answer: Double) {
        assertEquals(answer, dut(equation))
    }

    @ParameterizedTest
    @MethodSource("makeMinusOperationTestCase")
    fun `minus operation test with random value`(equation: String, answer: Double) {
        assertEquals(answer, dut(equation))
    }

    @ParameterizedTest
    @MethodSource("makeDivideOperationTestCase")
    fun `divide operation test with random value`(equation: String, answer: Double) {
        assertEquals(answer, dut(equation))
    }

    @ParameterizedTest
    @MethodSource("makeMultiplyOperationTestCase")
    fun `multiply operation test with random value`(equation: String, answer: Double) {
        assertEquals(answer, dut(equation))
    }

    @ParameterizedTest
    @MethodSource("makeComplexOperationTestCase")
    fun `complex operation test with random value`(equation: String, answer: Double) {
        assertEquals(answer, dut(equation))
    }

    companion object {
        private const val MAX_NUMBER = 1000000
        private const val MIN_NUMBER = 0

        @JvmStatic
        fun makePlusOperationTestCase(): List<Arguments> =
            (0..20).map {
                makeEquation(Operator.PLUS)
            }

        @JvmStatic
        fun makeMinusOperationTestCase(): List<Arguments> =
            (0..20).map {
                makeEquation(Operator.MINUS)
            }

        @JvmStatic
        fun makeDivideOperationTestCase(): List<Arguments> =
            (0..5).map {
                makeEquation(Operator.DIVIDE)
            }

        @JvmStatic
        fun makeMultiplyOperationTestCase(): List<Arguments> =
            (0..20).map {
                makeEquation(operator = Operator.MULTIPLY, count = 5)
            }

        @JvmStatic
        fun makeComplexOperationTestCase(): List<Arguments> =
            (0..20).map {
                makeRandomEquation()
            }

        private fun makeEquation(operator: Operator, count: Int = 20): Arguments {
            var answer = Random.nextInt(MIN_NUMBER, MAX_NUMBER).toDouble()
            var equation = "$answer"
            (0..Random.nextInt(1, count)).forEach { _ ->
                val number = Random.nextInt(MIN_NUMBER, MAX_NUMBER).toDouble()
                answer = calculate(answer, number, operator)
                equation += " ${operator.operand} $number"
            }
            return Arguments.of(equation.dropLast(2), answer)
        }

        private fun makeRandomEquation(count: Int = 20): Arguments {
            var answer = Random.nextInt(MIN_NUMBER, MAX_NUMBER).toDouble()
            var equation = "$answer"
            (0..Random.nextInt(1, count)).forEach { _ ->
                val operator = Operator.values().random()
                val number = Random.nextInt(MIN_NUMBER, MAX_NUMBER).toDouble()
                answer = calculate(answer, number, operator)
                equation += " ${operator.operand} $number"
            }
            return Arguments.of(equation.dropLast(2), answer)
        }

        private fun calculate(firstNumber: Double, secondNumber: Double, operator: Operator): Double =
            when (operator) {
                Operator.MINUS -> firstNumber - secondNumber
                Operator.DIVIDE -> firstNumber / secondNumber
                Operator.MULTIPLY -> firstNumber * secondNumber
                Operator.PLUS -> firstNumber + secondNumber
            }

        enum class Operator(val operand: String) {
            PLUS("+"),
            MINUS("-"),
            MULTIPLY("*"),
            DIVIDE("/");
        }
    }
}
