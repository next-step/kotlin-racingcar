package game.racingcar

import game.racingcar.domain.RacingCar
import game.racingcar.domain.RacingCars
import game.racingcar.move.AlwaysMoveStrategy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class RacingCarsTest {

    @Test
    fun `RacingCars가 AlwaysMoveStrategy로 생성되었을 때 모두 위치가 1씩 증가한다`() {
        // given
        val racingCars = RacingCars(listOf("haris", "horis", "huris").map { RacingCar(it, AlwaysMoveStrategy()) })
        // when
        val snapshot = racingCars.moveAll()
        // then
        snapshot.forEach {
            assertThat(it.location).isEqualTo(1)
        }
    }

    @Test
    fun `RacingCars가 AlawaysMoveStrategy로 생성되었을 때 승자는 모두가 된다`() {
        // given
        val racingCars = RacingCars(listOf("haris", "horis", "huris").map { RacingCar(it, AlwaysMoveStrategy()) })

        // when
        racingCars.moveAll()
        val winners: List<String> = racingCars.pickWinners()

        // then
        assertAll(
            { assertTrue(winners.contains("haris")) },
            { assertTrue(winners.contains("horis")) },
            { assertTrue(winners.contains("huris")) },
        )
    }
}
