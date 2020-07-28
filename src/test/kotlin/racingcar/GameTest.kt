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

        game.makeCar(3)

        assertThat(game.cars.size).isEqualTo(3)
    }
}
