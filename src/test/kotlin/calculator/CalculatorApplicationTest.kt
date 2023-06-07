package calculator

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class CalculatorApplicationTest {

    private val originalIn = System.`in`
    private val originalOut = System.out
    private lateinit var testOut: ByteArrayOutputStream

    @BeforeEach
    fun setUp() {
        testOut = ByteArrayOutputStream()
        System.setOut(PrintStream(testOut))
    }

    @AfterEach
    fun tearDown() {
        System.setIn(originalIn)
        System.setOut(originalOut)
    }

    private fun setInput(input: String) {
        ByteArrayInputStream(input.toByteArray()).use { testIn ->
            System.setIn(testIn)
        }
    }

    @Test
    fun `올바른 입력을 받고 10을 출력해야함`() {
        setInput("2 + 3 * 4 / 2")
        main()
        val output = testOut.toString().trim()
        assertEquals("10.0", output)
    }

    @Test
    fun `공백을 입력받음`() {
        setInput(" ")
        assertThrows<IllegalArgumentException> {
            main()
        }
    }

    @Test
    fun `빈값 입력 받음`() {
        val input = ""
        setInput(input)
        assertThrows<IllegalArgumentException> {
            main()
        }
    }
}
