package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream

class UserInputTest {
    @Test
    fun `숫자를 입력받는다`() {
        val userInput = UserInput.Int("질문", ByteArrayInputStream("1\n".toByteArray()))
        assertThat(userInput.answer()).isEqualTo(1)
    }

    @Test
    fun `쉼표로 구분된 문자를 입력받는다`() {
        val userInput = UserInput.StringArray("질문", ByteArrayInputStream("pobi,crong,honux\n".toByteArray()))
        assertThat(userInput.answer()).isEqualTo(listOf("pobi", "crong", "honux"))
    }
}
