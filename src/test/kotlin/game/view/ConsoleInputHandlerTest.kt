package game.view

import game.domain.ErrorMessage
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class ConsoleInputHandlerTest {

    @Test
    fun `입력받은 자동차 이름을 그대로 반환환다`() {
        // given
        val expect = "car1,car2,car3"
        val inputReader = TestInputWrapper(expect)
        val consoleInputHandler = ConsoleInputHandler(inputReader)

        // when
        val askForCarNames = consoleInputHandler.askForCarNames()

        // then
        assertThat(askForCarNames).isEqualTo(expect)
    }

    @Test
    fun `입력받은 자동차 이름이 null이면 예외를 던진다`() {
        // given
        val inputReader = TestInputWrapper(null)
        val consoleInputHandler = ConsoleInputHandler(inputReader)

        // when,then
        assertThatThrownBy { consoleInputHandler.askForCarNames() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(ErrorMessage.INVALID_INPUT_ERROR_MSG.message)
    }

    @Test
    fun `입력 받은 시도 횟수을 그대로 반환한다`() {
        // given
        val input = "5"
        val inputReader = TestInputWrapper(input)
        val consoleInputHandler = ConsoleInputHandler(inputReader)

        // when
        val askForRetryCount = consoleInputHandler.askForRetryCount()

        // then
        assertThat(askForRetryCount).isEqualTo(input)
    }

    @Test
    fun `입력 받은 시도 횟수가 null이면 예외를 던진다`() {
        // given
        val inputReader = TestInputWrapper(null)
        val consoleInputHandler = ConsoleInputHandler(inputReader)

        // when,then
        assertThatThrownBy { consoleInputHandler.askForRetryCount() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(ErrorMessage.INVALID_INPUT_ERROR_MSG.message)
    }

    class TestInputWrapper(private val input: String?) : InputWrapper {
        override fun readlnOrNull(): String? {
            return input
        }
    }
}
