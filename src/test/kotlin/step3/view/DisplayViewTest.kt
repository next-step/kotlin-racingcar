package step3.view

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

internal class DisplayViewTest {

    @Test
    fun testConsoleOutput() {
        val expectedOutput = "\n실행결과\n"

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        DisplayView.displayHeader()

        val consoleOutput = outputStream.toString()

        assertEquals(expectedOutput, consoleOutput)
    }
}