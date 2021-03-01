package racingcar

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream

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
        assertThat(outputStream.toString()).isEqualTo("pobi, honux가 최종 우승했습니다.")
    }
}
