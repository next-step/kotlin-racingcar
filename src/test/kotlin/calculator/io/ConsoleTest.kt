package calculator.io

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream

class ConsoleTest {

    private lateinit var console: Console
    private val originalIn = System.`in`

    @BeforeEach
    fun setUp() {
        console = Console()
    }

    @AfterEach
    fun tearDown() {
        System.setIn(originalIn)
    }

    private fun setInput(input: String) {
        ByteArrayInputStream(input.toByteArray()).use { testIn ->
            System.setIn(testIn)
        }
    }

    @Test
    fun `올바른 값 입력 받음`() {
        val input = "2 + 3 * 4 / 2"
        setInput(input)
        val userInput = console.getInput()
        assertEquals(input, userInput)
    }

    @Test
    fun `공백 입력 받음`() {
        val input = "  "
        setInput(input)
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            console.getInput()
        }
    }

    @Test
    fun `빈값 입력 받음`() {
        val input = ""
        setInput(input)
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            console.getInput()
        }
    }
}
