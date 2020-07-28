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
        val game = Game()

        game.makeCars(3)

        assertThat(game.cars.size).isEqualTo(3)
    }

    @Test
    fun ready_game() {
        val inputCarNum = 3
        val inputMoveTime = 5
        val game = Game()

        game.readyGame(inputCarNum, inputMoveTime)

        assertThat(game.cars.size).isEqualTo(3)
        assertThat(game.moveTime).isEqualTo(5)
    }
}
