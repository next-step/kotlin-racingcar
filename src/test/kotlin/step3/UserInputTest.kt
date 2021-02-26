package step3

import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream

class UserInputTest {
    @Test
    fun `숫자를 입력받는다`() {
        val userInput = UserInput.Int("질문", ByteArrayInputStream("1\n".toByteArray()))
        assertThat(userInput.answer()).isEqualTo(1)
    }
}
