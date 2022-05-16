package racingcar.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.constants.Message

/**
 * RacingController를 테스트하는 클래스
 * Created by Jaesungchi on 2022.05.07..
 */
class RacingGameTest {
    @Test
    fun `음수 횟수가 입력되면 에러가 발생한다`() {
        val racingGame = RacingGame(listOf(), -3)
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            racingGame.startGame()
        }.withMessageMatching(Message.ExceptionMessage.ENTERED_INVALID_NUMBER)
    }

    @Test
    fun `0이 입력되면 에러가 발생한다`() {
        val racingGame = RacingGame(listOf(Car("link")), 0)
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            racingGame.startGame()
        }.withMessageMatching(Message.ExceptionMessage.ENTERED_INVALID_NUMBER)
    }

    @Test
    fun `입력된 숫자만큼 레이스 결과가가 만들어졌는가`() {
        val racingGame = RacingGame(listOf(Car("link")), 3)
        assertThat(racingGame.startGame().size).isEqualTo(3)
    }
}
