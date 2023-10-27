package study.racingcar.domain

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class GameTest {

    // TODO : to be implemented
    @Test
    fun setGameRule() {}

    @Test
    fun play() {
        val gameRule = FourOrMoreGameRule()
        val game = Game(gameRule)

        // 정상 수행 로직임을 확인
        assertTrue(game.play())
    }
}
