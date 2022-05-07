package racingCar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import racingCar.etc.Message
import racingCar.view.InputView

/**
 * input에 대한 테스트
 * Created by Jaesungchi on 2022.05.07..
 */
class InputTest {
    @Test
    fun `0이 입력되었을 때 에러발생`() {
        val inputView = InputView()
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            inputView.changeStringToInt("0")
        }.withMessageMatching(Message.ExceptionMessage.ENTERED_INVALID_NUMBER)
    }

    @Test
    fun `음수가 입력되었을 때 에러발생`() {
        val inputView = InputView()
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            inputView.changeStringToInt("-1")
        }.withMessageMatching(Message.ExceptionMessage.ENTERED_INVALID_NUMBER)
    }

    @Test
    fun `글자가 입력되었을 때 에러발생`() {
        val inputView = InputView()
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            inputView.changeStringToInt("글자")
        }.withMessageMatching(Message.ExceptionMessage.IS_NOT_INTEGER)
    }

    @Test
    fun `빈칸이나 null이 입력되었을 때 에러발생`() {
        val inputView = InputView()
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            inputView.changeStringToInt(" ")
        }.withMessageMatching(Message.ExceptionMessage.IS_NULL_OR_BLANK)
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            inputView.changeStringToInt(null)
        }.withMessageMatching(Message.ExceptionMessage.IS_NULL_OR_BLANK)
    }
}
