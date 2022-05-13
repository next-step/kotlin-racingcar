package racingcar.controller

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.constants.Message

/**
 * RacingController를 테스트하는 클래스
 * Created by Jaesungchi on 2022.05.07..
 */
class RacingControllerTest {
    @Test
    fun `음수 횟수가 입력되었을 때`() {
        val racingController = RacingController()
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            racingController.startGame(listOf("hello"), -3)
        }.withMessageMatching(Message.ExceptionMessage.ENTERED_INVALID_NUMBER)
    }

    @Test
    fun `0이 입력되었을 때 에러발생`() {
        val racingController = RacingController()
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            racingController.startGame(listOf("hello"), 0)
        }.withMessageMatching(Message.ExceptionMessage.ENTERED_INVALID_NUMBER)
    }

    @Test
    fun `입력된 숫자만큼 레이스 결과가가 만들어졌는가`() {
        val racingController = RacingController()
        racingController.startGame(listOf("hello"), 3)
        assertThat(racingController.raceResults.size).isEqualTo(3)
    }
}
