package step4.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/**
 *
 * @author Leo
 */
class RaceManagerTest {

    private val raceManager = RaceManager(FakeForwardImpl())

    @Test
    fun `레이싱 참가자 생성 검증`() {

        // given
        val names = listOf(CarName("a"), CarName("b"))

        // when
        val cars = raceManager.getParticipants(names)

        // then
        assertThat(cars.size).isEqualTo(names.size)
    }

    @Test
    fun `레이싱 시작시 모든 참가자의 전진 이력 생성 검증`() {

        // given
        val totalCount = 5
        val names = listOf(CarName("a"), CarName("b"))
        val cars = raceManager.getParticipants(names)

        // when
        val movingHistories = raceManager.startRace(totalCount = totalCount, cars = cars)

        // then
        assertThat(movingHistories.size).isEqualTo(cars.size)
    }

    @Test
    fun `우승자 판단 검증`() {

        // given
        val totalCount = 5
        val names = listOf(CarName("a"), CarName("b"), CarName("c"))
        val cars = raceManager.getParticipants(names)

        // when
        val movingHistories = raceManager.startRace(totalCount = totalCount, cars = cars)
        val winners = raceManager.getWinnerNames(movingHistories)

        // then
        assertThat(winners.size).isEqualTo(3)
    }
}
