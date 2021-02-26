package step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingGameTest {
    @Test
    internal fun `레이싱게임 객체를 플레이수와 함께 생성한다`() {
        RacingGame(3)
    }

    @Test
    fun `이동결과를 제공한다`() {
        val racingGame = RacingGame(CarsTest.cars(3))

        racingGame.play(5)

        assertThat(racingGame.positions().size).isEqualTo(5)

        for ((index, positions) in racingGame.positions().withIndex()) {
            assertThat(positions).contains(
                Position(position = index + 1),
                Position(position = index + 1),
                Position(position = index + 1)
            )
        }
    }

    class RacingGame(private val cars: Cars) {
        private val positions: MutableList<Positions> = arrayListOf()

        constructor(cars: Int) : this(Cars(cars))

        fun play(playCount: Int) {
            for (i in 0 until playCount) {
                cars.drive()
                positions.add(cars.positions)
            }
        }

        fun positions(): List<Positions> = positions
    }
}
