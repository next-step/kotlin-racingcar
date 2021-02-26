package step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.util.Scanner

class UserInputTest {
    @Test
    fun `숫자를 입력받는다`() {
        val userInput = UserInput.Int("질문", ByteArrayInputStream("1\n".toByteArray()))
        assertThat(userInput.answer()).isEqualTo(1)
    }

    interface UserInput<T> {
        fun answer(): T

        class Int(private val question: String, inputStream: InputStream) : UserInput<kotlin.Int> {
            private val scanner = Scanner(inputStream)
            override fun answer(): kotlin.Int {
                println(question)
                return scanner.nextInt()
            }
        }
    }
}
