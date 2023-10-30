package game

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class ConsoleInputHandlerTest {

    @Test
    fun `입력 받은 내용을 그대로 반환환다`() {
        val inputReader = mock(InputWrapper::class.java)
        val expect = "car1,car2,car3"
        `when`(inputReader.readlnOrNull()).thenReturn(expect)

        val consoleInputHandler = ConsoleInputHandler(inputReader)
        assertThat(consoleInputHandler.askForCarNames()).isEqualTo(expect)
    }

    @Test
    fun `입력 받은 내용이 null이면 예외를 던진다`() {
        val inputReader = mock(InputWrapper::class.java)
        `when`(inputReader.readlnOrNull()).thenReturn(null)

        val consoleInputHandler = ConsoleInputHandler(inputReader)
        assertThatThrownBy { consoleInputHandler.askForCarNames() }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(ErrorMessage.INVALID_INPUT_ERROR_MSG.message)
    }

    @Test
    fun askForRetryCount() {
    }
}
