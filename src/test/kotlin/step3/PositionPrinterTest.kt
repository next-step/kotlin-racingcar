package step3

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream

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
}
