package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingGameTest {
    @Test
    fun `이동결과를 제공한다`() {
        val racingGame = RacingGame(CarsTest.cars(CAR_COUNT))

        racingGame.play(PLAY_COUNT)

        assertThat(racingGame.positions.size).isEqualTo(PLAY_COUNT)

        assertThat(racingGame.positions.withIndex()).allSatisfy {
            assertThat(it.value).containsExactly(*Position(position = it.index + 1) copy CAR_COUNT)
        }
    }

    private infix fun Position.copy(count: Int): Array<Position> = (0 until count)
        .map { Position(position = this.int) }
        .toTypedArray()

    companion object {
        private const val CAR_COUNT = 3
        private const val PLAY_COUNT = 3
    }
}
