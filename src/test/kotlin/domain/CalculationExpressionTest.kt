package domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class CalculationExpressionTest {
    companion object {
        const val ADDITION = "+"
        const val SUBTRACT = "-"
        const val DIVISION = "/"
        const val MULTIPLICATION = "*"
    }

    @Test
    fun `피연산자_분리_테스트`() {
        lateinit var testOperandList: List<String>
        assertAll(
            {
                testOperandList = listOf("1.0", "2", "3", "4")
                for (i in testOperandList.indices) {
                    assertEquals(
                        testOperandList[i].toDouble(),
                        CalculationExpression("1 + 2 * 3 + 4").operand.operandList[i]
                    )
                }
            },
            {
                testOperandList = listOf("-1", "-2", "100", "4")
                for (i in testOperandList.indices) {
                    assertEquals(
                        testOperandList[i].toDouble(),
                        CalculationExpression("-1 + -2 * 100 / 4").operand.operandList[i]
                    )
                }
            },
            {
                testOperandList = listOf("1", "-21", "23", "124")
                for (i in testOperandList.indices) {
                    assertEquals(
                        testOperandList[i].toDouble(),
                        CalculationExpression("1 / -21 * 23 + 124").operand.operandList[i]
                    )
                }
            },
            {
                testOperandList = listOf("99", "78", "66", "-34")
                for (i in testOperandList.indices) {
                    assertEquals(
                        testOperandList[i].toDouble(),
                        CalculationExpression("99 * 78 / 66 + -34").operand.operandList[i]
                    )
                }
            }
        )
    }

    @Test
    fun `연산자_분리_테스트`() {
        lateinit var testOperatorList: List<String>
        assertAll(
            {
                testOperatorList = listOf(ADDITION, MULTIPLICATION, ADDITION)
                for (i in testOperatorList.indices) {
                    assertEquals(testOperatorList[i], CalculationExpression("1 + 2 * 3 + 4").operator.operatorList[i])
                }
            },
            {
                testOperatorList = listOf(ADDITION, MULTIPLICATION, DIVISION)
                for (i in testOperatorList.indices) {
                    assertEquals(
                        testOperatorList[i],
                        CalculationExpression("-1 + -2 * 100 / 4").operator.operatorList[i]
                    )
                }
            },
            {
                testOperatorList = listOf(DIVISION, MULTIPLICATION, SUBTRACT)
                for (i in testOperatorList.indices) {
                    assertEquals(
                        testOperatorList[i],
                        CalculationExpression("1 / -21 * 23 - 124").operator.operatorList[i]
                    )
                }
            },
            {
                testOperatorList = listOf(MULTIPLICATION, DIVISION, ADDITION)
                for (i in testOperatorList.indices) {
                    assertEquals(
                        testOperatorList[i],
                        CalculationExpression("99 * 78 / 66 + -34").operator.operatorList[i]
                    )
                }
            }
        )
    }
}
