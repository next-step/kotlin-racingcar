package game.racingcar

import game.racingcar.domain.RacingCar
import game.racingcar.domain.RacingCarGame
import game.racingcar.domain.RacingCars
import game.racingcar.dto.CarLocation
import game.racingcar.move.AlwaysMoveStrategy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RacingCarGameTest() {

    @Test
    fun `RacingCarGame이 AlwaysMoveStrategy로 생성되었을 때 위치 스냅샷이 1씩 증가한다`() {
        // given
        val racingCars = RacingCars(listOf("haris", "horis", "huris").map { RacingCar(it, AlwaysMoveStrategy()) })
        val racingCarGame = RacingCarGame(1, racingCars)

        // when
        val locationSnapshots = racingCarGame.play()

        // then
        assertThat(locationSnapshots.carLocationSnapshots.size).isEqualTo(1)
        assertThat(locationSnapshots.carLocationSnapshots[0].locations.size).isEqualTo(3)
        assertThat(locationSnapshots.carLocationSnapshots[0].locations[0]).isEqualTo(CarLocation("haris", 1))
        assertThat(locationSnapshots.carLocationSnapshots[0].locations[1]).isEqualTo(CarLocation("horis", 1))
        assertThat(locationSnapshots.carLocationSnapshots[0].locations[2]).isEqualTo(CarLocation("huris", 1))
    }
}
