package racingcar.domain.vo

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import racingcar.domain.RacingCarFixture
import racingcar.domain.RacingCars

@DisplayName("현황판(Scoreboard)")
class ScoreboardTest {
    @Test
    fun `현황판의 Lap들을 가져올 수 있다`() {
        val lap1 = Lap.of(1)
        val lap2 = Lap.of(2)
        val racingCars = RacingCars(listOf(RacingCarFixture.MOVING_CAR))
        val scoreboard = Scoreboard(mapOf(lap1 to racingCars, lap2 to racingCars.race()))
        assertThat(scoreboard.laps()).isEqualTo(Laps.of(2))
        assertThat(scoreboard.laps().toList()).containsExactly(lap1, lap2)
    }

    @Test
    fun `Lap별 현황을 가져올 수 있다`() {
        val lap = Lap.of(1)
        val racingCars = RacingCars(listOf(RacingCarFixture.MOVING_CAR))
        val scoreboard = Scoreboard(mapOf(lap to racingCars))
        assertThat(scoreboard.snapshotOf(lap)).isEqualTo(racingCars)
    }

    @Test
    fun `Lap별 현황을 현황판에 기록하면 새 현황이 추가된다`() {
        // given
        val car1 = RacingCarFixture.MOVING_CAR
        val car2 = RacingCarFixture.STATIC_CAR
        val lap1 = Lap.of(1)
        val lap2 = Lap.of(2)

        val racingCars = RacingCars(listOf(car1, car2))
        val expected = racingCars.race()
        val scoreboard = Scoreboard(mapOf(lap1 to racingCars))

        // when
        val updatedScoreboard = scoreboard.record(lap2, expected)

        // then
        assertThat(updatedScoreboard.snapshotOf(lap1)).isEqualTo(racingCars)
        assertThat(updatedScoreboard.snapshotOf(lap2)).isEqualTo(expected)
    }

    @Test
    fun `우승자를 결정한다`() {
        // given
        val movingCar = RacingCarFixture.MOVING_CAR
        val staticCar = RacingCarFixture.STATIC_CAR
        val racingCars = RacingCars(listOf(movingCar, staticCar))
        val lap1 = Lap.of(1)
        val lap2 = Lap.of(2)

        // when
        val scoreboard = Scoreboard(mapOf(lap1 to racingCars, lap2 to racingCars.race()))

        // then
        assertAll(
            {
                assertThat(scoreboard.winnerPositionOf(lap1))
                    .isEqualTo(staticCar.position)
                    .isEqualTo(movingCar.position)
            },
            {
                assertThat(scoreboard.winnerPositionOf(lap2))
                    .isEqualTo(Position(2))
                    .isEqualTo(movingCar.moved().position)
                    .isNotEqualTo(staticCar.moved().position)
            }
        )
    }
}
