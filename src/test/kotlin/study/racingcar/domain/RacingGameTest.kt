package study.racingcar.domain

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import study.racingcar.application.MockReader
import study.racingcar.view.InputView

class RacingGameTest {

    // TODO-review : 컨트롤러(오케스트레이션) 객체인 RacingGame 을 테스트할 경우, run 이 정상동작 함 이외는 테스트 할 수 없네요.
    //  도메인 로직의 밖의 영역이니,, 테스트를 할 수 없는 것이 맞는 것 같기도 하고요. 코멘트 부탁드려요!
    @Test
    fun `racingGame 이 정상 동작한다`() {
        // given
        val inputView = InputView(MockReader("abc,def", "3"))
        val gameRule = FourOrMoreGameRule()

        // when
        val racingGame = RacingGame(inputView, gameRule)

        // then
        racingGame.run()
    }
}