package racing

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarNameParserTest {
    private val parser = CarNameParser()

    @Test
    fun `입력받은 이름이 ,기준으로 잘 스플릿된다`() {
        val carNames = parser.parse("서진혁,카샤,next,step")

        assertEquals(listOf("서진혁", "카샤", "next", "step"), carNames)
    }

    @Test
    fun `이름이 5글자가 넘으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            parser.parse("서진혁,카샤,nextstep")
        }
    }
}
