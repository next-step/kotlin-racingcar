package racingcar.view

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import racingcar.constants.Message

/**
 * input에 대한 테스트
 * Created by Jaesungchi on 2022.05.07..
 */
class InputViewTest {

    @Test
    fun `차량 이름 입력에 null이 입력되었을 때`() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            InputView.getCarNames { null }
        }.withMessageMatching(Message.ExceptionMessage.IS_NULL_OR_BLANK)
    }

    @Test
    fun `시도할 횟수 입력에 글자가 입력되었을 때`() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            InputView.getNumberOfRaces { "글자" }
        }.withMessageMatching(Message.ExceptionMessage.IS_NOT_INTEGER)
    }

    @Test
    fun `시도할 횟수 입력에 null이 입력되었을 때`() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            InputView.getNumberOfRaces { null }
        }.withMessageMatching(Message.ExceptionMessage.IS_NULL_OR_BLANK)
    }

    @Test
    fun `시도할 횟수 입력에 빈칸이 입력되었을 때`() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            InputView.getNumberOfRaces { " " }
        }.withMessageMatching(Message.ExceptionMessage.IS_NULL_OR_BLANK)
    }
}
