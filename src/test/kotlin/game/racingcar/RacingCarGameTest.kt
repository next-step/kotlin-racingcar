package game.racingcar

import game.racingcar.move.AlwaysMoveStrategy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RacingCarGameTest() {

    @Test
    fun `RacingCarGame이 AlwaysMoveStrategy로 생성되었을 때 위치 스냅샷이 1씩 증가한다`() {
        // given
        val racingCarGame = RacingCarGame(listOf("haris", "horis", "huris"), 5, AlwaysMoveStrategy())

        // when
        val locationSnapshots = racingCarGame.play()

        // then
        locationSnapshots.forEachIndexed { expected, locationOfCars ->
            locationOfCars.locations.forEach { location ->
                assertThat(location).isEqualTo(expected + 1)
            }
        }
    }
}
