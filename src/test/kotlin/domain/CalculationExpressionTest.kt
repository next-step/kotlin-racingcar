package domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import java.lang.IllegalArgumentException

internal class CalculationExpressionTest {
    companion object {
        const val ADDITION = "+"
        const val SUBTRACT = "-"
        const val DIVISION = "/"
        const val MULTIPLICATION = "*"
    }

    @Test
    fun `공백_예외_테스트`() {
        assertThrows(IllegalArgumentException::class.java) {
            CalculationExpression("1 + 2 *  + 4")
        }
    }

    @Test
    fun `유효한_숫자가_아닐_경우_예외_테스트`() {
        assertAll(
            {
                assertThrows(IllegalArgumentException::class.java) {
                    CalculationExpression("A + 2 *  + 4")
                }
            },
            {
                assertThrows(IllegalArgumentException::class.java) {
                    CalculationExpression("+ + 2 *  + 4")
                }
            }
        )
    }

    @Test
    fun `유효한_연산자가_아닐_경우_예외_테스트`() {
        assertAll(
            {
                assertThrows(IllegalArgumentException::class.java) {
                    CalculationExpression("1 @ 2 * 3 + 4")
                }
            },
            {
                assertThrows(IllegalArgumentException::class.java) {
                    CalculationExpression("73 - 2 A 33 + 4")
                }
            }
        )
    }

    @Test
    fun `피연산자_분리_테스트`() {
        lateinit var testOperands: List<String>
        assertAll(
            {
                testOperands = listOf("1.0", "2", "3", "4")
                for (i in testOperands.indices) {
                    assertEquals(
                        testOperands[i].toDouble(),
                        CalculationExpression("1 + 2 * 3 + 4").operand.operands[i]
                    )
                }
            },
            {
                testOperands = listOf("-1", "-2", "100", "4")
                for (i in testOperands.indices) {
                    assertEquals(
                        testOperands[i].toDouble(),
                        CalculationExpression("-1 + -2 * 100 / 4").operand.operands[i]
                    )
                }
            },
            {
                testOperands = listOf("1", "-21", "23", "124")
                for (i in testOperands.indices) {
                    assertEquals(
                        testOperands[i].toDouble(),
                        CalculationExpression("1 / -21 * 23 + 124").operand.operands[i]
                    )
                }
            },
            {
                testOperands = listOf("99", "78", "66", "-34")
                for (i in testOperands.indices) {
                    assertEquals(
                        testOperands[i].toDouble(),
                        CalculationExpression("99 * 78 / 66 + -34").operand.operands[i]
                    )
                }
            }
        )
    }

    @Test
    fun `연산자_분리_테스트`() {
        lateinit var testOperators: List<String>
        assertAll(
            {
                testOperators = listOf(ADDITION, MULTIPLICATION, ADDITION)
                for (i in testOperators.indices) {
                    assertEquals(
                        testOperators[i],
                        CalculationExpression("1 + 2 * 3 + 4").arithmeticOperator.operators[i]
                    )
                }
            },
            {
                testOperators = listOf(ADDITION, MULTIPLICATION, DIVISION)
                for (i in testOperators.indices) {
                    assertEquals(
                        testOperators[i],
                        CalculationExpression("-1 + -2 * 100 / 4").arithmeticOperator.operators[i]
                    )
                }
            },
            {
                testOperators = listOf(DIVISION, MULTIPLICATION, SUBTRACT)
                for (i in testOperators.indices) {
                    assertEquals(
                        testOperators[i],
                        CalculationExpression("1 / -21 * 23 - 124").arithmeticOperator.operators[i]
                    )
                }
            },
            {
                testOperators = listOf(MULTIPLICATION, DIVISION, ADDITION)
                for (i in testOperators.indices) {
                    assertEquals(
                        testOperators[i],
                        CalculationExpression("99 * 78 / 66 + -34").arithmeticOperator.operators[i]
                    )
                }
            }
        )
    }
}
