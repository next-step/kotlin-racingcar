package game.racingcar

import game.racingcar.domain.RacingCar
import game.racingcar.domain.RacingCars
import game.racingcar.move.AlwaysMoveStrategy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertFalse
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

    @Test
    fun `RacingCars의 위치를 3, 2, 1 로 생성했을 때 위치가 3인 RacingCar가 승리한다`() {
        // given
        val racingCars = RacingCars(
            listOf(
                RacingCar("haris", AlwaysMoveStrategy(), 3),
                RacingCar("horis", AlwaysMoveStrategy(), 2),
                RacingCar("huris", AlwaysMoveStrategy(), 1)
            )
        )

        // when
        val winners: List<String> = racingCars.pickWinners()

        // then
        assertAll(
            { assertTrue(winners.contains("haris")) },
            { assertFalse(winners.contains("horis")) },
            { assertFalse(winners.contains("huris")) },
        )
    }
}
