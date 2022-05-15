package racingcar.view

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.NullSource
import racingcar.constants.Message

/**
 * input에 대한 테스트
 * Created by Jaesungchi on 2022.05.07..
 */
class InputViewTest {

    @ParameterizedTest
    @NullSource
    fun `차량 이름 입력에 null이 입력되면 에러가 발생한다`(source: String?) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            InputView.getCarNames { source }
        }.withMessageMatching(Message.ExceptionMessage.IS_NULL_OR_BLANK)
    }

    @Test
    fun `시도할 횟수 입력에 글자가 입력되면 에러가 발생한다`() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            InputView.getNumberOfRaces { "글자" }
        }.withMessageMatching(Message.ExceptionMessage.IS_NOT_INTEGER)
    }

    @ParameterizedTest
    @NullSource
    fun `시도할 횟수 입력에 null이 입력되면 에러가 발생한다`(source: String?) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            InputView.getNumberOfRaces { source }
        }.withMessageMatching(Message.ExceptionMessage.IS_NULL_OR_BLANK)
    }

    @ParameterizedTest
    @EmptySource
    fun `시도할 횟수 입력에 빈칸이 입력되면 에러가 발생한다`(source: String) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            InputView.getNumberOfRaces { source }
        }.withMessageMatching(Message.ExceptionMessage.IS_NULL_OR_BLANK)
    }
}
