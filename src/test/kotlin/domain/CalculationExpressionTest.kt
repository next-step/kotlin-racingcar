package domain

import constant.Constants.Companion.ADDITION
import constant.Constants.Companion.DIVISION
import constant.Constants.Companion.MULTIPLICATION
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class CalculationExpressionTest {

    @Test
    fun getOperand() {
        var testOperandList = listOf("1", "2", "3", "4")
        for (i in testOperandList.indices) {
            assertEquals(testOperandList[i], CalculationExpression("1 + 2 * 3 + 4").operand.operandList[i])
        }

        testOperandList = listOf("-1", "-2", "100", "4")
        for (i in testOperandList.indices) {
            assertEquals(testOperandList[i], CalculationExpression("-1 + -2 * 100 / 4").operand.operandList[i])
        }

        testOperandList = listOf("1", "-21", "23", "124")
        for (i in testOperandList.indices) {
            assertEquals(testOperandList[i], CalculationExpression("1 / -21 * 23 + 124").operand.operandList[i])
        }

        testOperandList = listOf("99", "78", "66", "-34")
        for (i in testOperandList.indices) {
            assertEquals(testOperandList[i], CalculationExpression("99 * 78 / 66 + -34").operand.operandList[i])
        }
    }

    @Test
    fun getOperator() {
        var testOperatorList = listOf(ADDITION, MULTIPLICATION, ADDITION)
        for (i in testOperatorList.indices) {
            assertEquals(testOperatorList[i], CalculationExpression("1 + 2 * 3 + 4").operator.operatorList[i])
        }

        testOperatorList = listOf(ADDITION, MULTIPLICATION, DIVISION)
        for (i in testOperatorList.indices) {
            assertEquals(testOperatorList[i], CalculationExpression("-1 + -2 * 100 / 4").operator.operatorList[i])
        }

        testOperatorList = listOf(DIVISION, MULTIPLICATION, ADDITION)
        for (i in testOperatorList.indices) {
            assertEquals(testOperatorList[i], CalculationExpression("1 / -21 * 23 + 124").operator.operatorList[i])
        }

        testOperatorList = listOf(MULTIPLICATION, DIVISION, ADDITION)
        for (i in testOperatorList.indices) {
            assertEquals(testOperatorList[i], CalculationExpression("99 * 78 / 66 + -34").operator.operatorList[i])
        }
    }
}
