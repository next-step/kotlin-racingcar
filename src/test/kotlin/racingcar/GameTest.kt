package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GameTest {
    @Test
    fun test_range() {
        var a = 0
        for (x in 1..3) {
            a += 1
        }
        assertThat(a).isEqualTo(3)
    }

    @Test
    fun make_cars() {
        val game = Game(3, 1)

        assertThat(game.getCars().size).isEqualTo(3)
    }

    @Test
    fun ready_game() {
        val inputCarNum = 3
        val inputMoveTime = 5

        val game = Game(inputCarNum, inputMoveTime)

        assertThat(game.getCars().size).isEqualTo(3)
        assertThat(game.moveTime).isEqualTo(5)
    }

    @Test
    fun race() {
        val carNum = 3
        val moveTime = 5
        val game = Game(carNum, moveTime)

        game.race()

        assertThat(game.moveTime).isEqualTo(moveTime - 1)
    }

    @Test
    fun game_is_end() {
        val carNum = 3
        val moveTime = 0
        val game = Game(carNum, moveTime)

        val result = game.isEndGame()

        assertThat(result).isTrue()
    }
}
