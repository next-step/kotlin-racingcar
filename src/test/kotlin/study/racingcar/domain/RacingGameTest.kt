package study.racingcar.domain

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import study.racingcar.application.MockReader
import study.racingcar.view.InputView

class RacingGameTest {
    private lateinit var inputView: InputView

    @BeforeEach
    fun setUp() {
        inputView = InputView(MockReader("abc,def", "3"))
    }

    @Test
    fun `언제나 이기는 룰을 적용했을때, 게임이 진행된 후, 모든 참여자가 공동의 승자가 된다`() {
        // given
        val winGameRule = WinGameRule()

        // when
        val racingGame = RacingGame(inputView, winGameRule)
        val winners = racingGame.run()

        // then
        assertEquals("abc", winners[0].name.toString())
        assertEquals("def", winners[1].name.toString())
    }

    @Test
    fun `무작위값이 4 이상인 경우 이기는 룰을 적용했을때, 게임이 진행된 후, 최소 1명 이상의 승자가 발생한다`() {
        // given
        val fourOrMoreGameRule = FourOrMoreGameRule()

        // when
        val racingGame = RacingGame(inputView, fourOrMoreGameRule)
        val winners = racingGame.run()

        // then
        assertTrue(winners.isNotEmpty())
    }
}
