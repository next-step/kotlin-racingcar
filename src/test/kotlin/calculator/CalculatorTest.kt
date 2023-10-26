package calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.OutputStream

class CalculatorTest {
    private fun setUpCalculator(expression: String, outputStream: OutputStream): Calculator =
        Calculator(expression.byteInputStream(), outputStream)

    @Test
    fun testCalculateAddExpression() {
        val outputStream = ByteArrayOutputStream()
        setUpCalculator("20 + 30", outputStream).also { it.run() }

        assertEquals(String(outputStream.toByteArray()), "50")
    }

    @Test
    fun testCalculateSubtractExpression() {
        val outputStream = ByteArrayOutputStream()
        setUpCalculator("20 - 30", outputStream).also { it.run() }

        assertEquals(String(outputStream.toByteArray()), "-10")
    }

    @Test
    fun testCalculateMultiplyExpression() {
        val outputStream = ByteArrayOutputStream()
        setUpCalculator("20 * 30", outputStream).also { it.run() }

        assertEquals(String(outputStream.toByteArray()), "600")
    }

    @Test
    fun testCalculateDivideExpression() {
        val outputStream = ByteArrayOutputStream()
        setUpCalculator("20 / 30", outputStream).also { it.run() }

        assertEquals(String(outputStream.toByteArray()), "0")
    }

    @Test
    fun testCalculateExpressionWithTwoOperator() {
        val outputStream = ByteArrayOutputStream()
        setUpCalculator("20 / 4 + 10", outputStream).also { it.run() }

        assertEquals(String(outputStream.toByteArray()), "15")
    }

    @Test
    fun testCalculateExpressionWithThreeOperator() {
        val outputStream = ByteArrayOutputStream()
        setUpCalculator("20 / 4 + 10 * 6", outputStream).also { it.run() }

        assertEquals(String(outputStream.toByteArray()), "90")
    }
}
