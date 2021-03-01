package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintWriter

class PrinterTest {
    @Test
    fun `이름과 위치를 출력한다`() {
        val outputStream = ByteArrayOutputStream()
        val positionPrinter = PositionPrinter(
            listOf(
                Positions(
                    "pobi" to 3,
                    "crong" to 2
                )
            ),
            outputStream
        )

        positionPrinter.print()

        assertThat(outputStream.toString()).isEqualTo(
            """
            pobi : ---
            crong : --
            
            
            """.trimIndent()
        )
    }

    @Test
    fun `우승자를 출력한다`() {
        val outputStream = ByteArrayOutputStream()
        WinnerPrinter(listOf("pobi", "crong"), outputStream).print()
        assertThat(outputStream.toString()).isEqualTo("pobi, crong가 최종 우승했습니다.\n")
    }

    class WinnerPrinter(private val names: List<String>, outputStream: ByteArrayOutputStream) {
        fun print() {
            printWriter.println(
                "${names.joinToString(", ")}가 최종 우승했습니다."
            )
        }

        private val printWriter = PrintWriter(outputStream, true)
    }
}
