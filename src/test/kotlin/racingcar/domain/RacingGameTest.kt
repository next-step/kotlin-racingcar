package racingcar.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.constants.Message

/**
 * RacingController를 테스트하는 클래스
 * Created by Jaesungchi on 2022.05.07..
 */
class RacingGameTest {
    @ParameterizedTest
    @ValueSource(ints = [-3, 0])
    fun `양수가 아닌 숫자가 입력되면 에러가 발생한다`(source: Int) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            RacingGame(listOf(), source)
        }.withMessageMatching(Message.ExceptionMessage.ENTERED_INVALID_NUMBER)
    }

    @Test
    fun `입력된 숫자만큼 레이스 결과가가 만들어졌는가`() {
        val racingGame = RacingGame(listOf(Car("link")), 3)
        assertThat(racingGame.startGame().size).isEqualTo(3)
    }
}
