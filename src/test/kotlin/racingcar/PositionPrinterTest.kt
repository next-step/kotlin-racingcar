package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream

class PositionPrinterTest {
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

        Assertions.assertThat(outputStream.toString()).isEqualTo(
            """
            pobi : ---
            crong : --
            
            
            """.trimIndent()
        )
    }
}
