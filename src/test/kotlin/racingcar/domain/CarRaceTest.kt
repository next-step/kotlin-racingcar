package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.Location.Companion.initialLocation

class CarRaceTest {
    @Test
    fun `레이스 참가 차량 수를 입력받을 수 있다`() {
        // given
        val tCarCount = 3L
        val tMaxRaceRound = 5L
        val sut = CarRace(carRaceProperties(tCarCount, tMaxRaceRound, alwaysGoForwardRaceMoveRule()))

        // when

        // then
        assertThat(sut.raceStatus().cars.size).isEqualTo(tCarCount)
    }

    @Test
    fun `레이스가 진행중인 상태를 알 수 있다`() {
        // given
        val tCarCount = 3L
        val tMaxRaceRound = 5L
        val sut = CarRace(carRaceProperties(tCarCount, tMaxRaceRound, alwaysGoForwardRaceMoveRule()))

        // when

        // then
        with(sut.raceStatus()) {
            repeat(tCarCount.toInt()) {
                assertThat(cars[it].location).isEqualTo(initialLocation)
            }
        }
    }

    @Test
    fun `시도할 횟수만큼 레이스가 진행되었다면 레이스 종료상태를 반환할 수 있다`() {
        // given
        val tCarCount = 3L
        val tMaxRaceRound = 5L
        val sut = CarRace(carRaceProperties(tCarCount, tMaxRaceRound, alwaysGoForwardRaceMoveRule()))

        // when
        val beforeRace = sut.finished()
        repeat(tMaxRaceRound.toInt()) { sut.doRace() }
        val afterRace = sut.finished()

        // then
        assertThat(beforeRace).isEqualTo(false)
        assertThat(afterRace).isEqualTo(true)
    }

    @Test
    fun `RaceMoveRule 에 따라 레이스를 시도할 때마다 차량의 위치가 변할 수 있다`() {
        // given
        val tCarCount = 1L
        val tMaxRaceRound = 5L
        val sut = CarRace(carRaceProperties(tCarCount, tMaxRaceRound, alwaysGoForwardRaceMoveRule()))

        // when
        val initialStatus = sut.raceStatus()
        val afterFirstRoundStatus = sut.doRace()
        val afterSecondRoundStatus = sut.doRace()

        // then
        assertThat(initialStatus.cars.first().location).isEqualTo(0.toLocation())
        assertThat(afterFirstRoundStatus.cars.first().location).isEqualTo(1.toLocation())
        assertThat(afterSecondRoundStatus.cars.first().location).isEqualTo(2.toLocation())
    }

    private fun alwaysGoForwardRaceMoveRule(): RaceMoveRule = AlwaysGoForwardRaceMoveRule()

    private fun carRaceProperties(participantCount: Long, maxRound: Long, raceMoveRule: RaceMoveRule) = CarRaceProperties(
        participantCount = participantCount,
        maxRound = maxRound,
        raceMoveRule = raceMoveRule
    )
}

internal class AlwaysGoForwardRaceMoveRule : RaceMoveRule {
    override fun canMove(car: Car): Boolean = true
}
