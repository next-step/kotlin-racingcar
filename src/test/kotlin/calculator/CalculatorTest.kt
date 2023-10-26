package calculator

import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.OutputStream

class CalculatorTest {
    private fun setUpCalculator(expression: String, outputStream: OutputStream): Calculator =
        Calculator(expression.byteInputStream(), outputStream)

    @Test
    fun testCalculateAddExpression() {
        val outputStream = ByteArrayOutputStream()
        setUpCalculator("test", outputStream).also { it.run() }
    }

    @Test
    fun testCalculateSubtractExpression() {
    }

    @Test
    fun testCalculateMultiplyExpression() {
    }

    @Test
    fun testCalculateDivideExpression() {
    }

    @Test
    fun testCalculateExpressionWithTwoOperator() {
    }

    @Test
    fun testCalculateExpressionWithThreeOperator() {
    }
}
