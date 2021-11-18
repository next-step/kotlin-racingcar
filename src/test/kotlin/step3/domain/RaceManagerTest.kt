package step3.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/**
 *
 * @author Leo
 */
class RaceManagerTest {

    @Test
    fun `레이싱 참가자 생성 검증`() {

        // given
        val raceManager = RaceManager()
        val participantsCount = 3

        // when
        val cars = raceManager.getParticipants(participantsCount)

        // then
        assertThat(cars.size).isEqualTo(participantsCount)

    }

    @Test
    fun `레이싱 시작시 모든 참가자의 전진 이력 생성 검증`() {

        // given
        val raceManager = RaceManager()
        val totalCount = 5
        val cars = raceManager.getParticipants(3)

        // when
        val movingHistories = raceManager.startRace(totalCount = totalCount, cars = cars)

        // then
        assertThat(movingHistories.size).isEqualTo(cars.size)

    }

}
