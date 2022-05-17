package game.racingcar.domain

import game.racingcar.strategy.MustOneMoveStrategy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("레이싱 경주 & 우승자")
internal class RacingTrackTest {

    @Test
    fun `경주 테스트`() {
        // given
        val expected = 30
        val carNames = listOf("a", "b", "c", "d")
        val racingTrack = RacingTrack(carNames.map { Car(it) })

        // when
        val cars = racingTrack.race(expected, MustOneMoveStrategy())

        // then
        cars.forEach { assertThat(it.position).isEqualTo(expected) }
    }

    @Test
    fun `경주 우승자 1명`() {
        // given
        val cars = listOf(Car("jade"), Car("koh"))
        val racingTrack = RacingTrack(cars)

        // when
        repeat(10) {
            cars[0].move(MustOneMoveStrategy())
        }
        val winners = racingTrack.getWinners()

        // then
        assertThat(winners).anyMatch { it.name == "jade" }
        assertThat(winners).hasSize(1)
    }

    @Test
    fun `경주 우승자 여러명`() {
        // given
        val cars = listOf(Car("jade"), Car("koh"))
        val racingTrack = RacingTrack(cars)

        // when
        repeat(10) {
            cars.forEach { it.move(MustOneMoveStrategy()) }
        }
        val winners = racingTrack.getWinners()

        // then
        assertThat(winners).allMatch { winner -> cars.map { it.name }.contains(winner.name) }
        assertThat(winners).hasSize(2)
    }
}
