package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.Game

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
        val game = Game(listOf("name", "test", "test1"), 1)

        assertThat(game.cars.size).isEqualTo(3)
    }

    @Test
    fun ready_game() {
        val carName = listOf("name", "test", "test1")
        val inputMoveTime = 5

        val game = Game(carName, inputMoveTime)

        assertThat(game.cars.size).isEqualTo(3)
        assertThat(game.moveTime).isEqualTo(5)
    }

    @Test
    fun race() {
        val carName = listOf("name")
        val moveTime = 5
        val game = Game(carName, moveTime)

        game.race()

        assertThat(game.moveTime).isEqualTo(moveTime - 1)
    }

    @Test
    fun game_is_end() {
        val carName = listOf("name")
        val moveTime = 0
        val game = Game(carName, moveTime)

        val result = game.isEndGame()

        assertThat(result).isTrue()
    }
}
