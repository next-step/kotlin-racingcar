package study.racingcar.domain

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import study.racingcar.application.MockReader
import study.racingcar.view.InputView

class RacingGameTest {

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