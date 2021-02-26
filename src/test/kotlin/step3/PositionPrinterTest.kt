package step3

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.OutputStream
import java.io.PrintWriter

class PositionPrinterTest {
    @Test
    fun `위치를 출력한다`() {
        val outputStream = ByteArrayOutputStream()
        val positionPrinter = PositionPrinter(listOf(Positions(3, 2)), outputStream)

        positionPrinter.print()

        Assertions.assertThat(outputStream.toString()).isEqualTo(
            """
            ---
            --
            
            
            """.trimIndent()
        )
    }

    class PositionPrinter(private val positions: List<Positions>, outputStream: OutputStream) {
        private val printWriter: PrintWriter = PrintWriter(outputStream, true)

        fun print() {
            for (positions in positions) {
                positions.map { "-".repeat(it.intValue()) }
                    .forEach(printWriter::println)

                printWriter.println()
            }
        }
    }
}
