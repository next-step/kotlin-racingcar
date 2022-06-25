package racingcar.domain.race

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.CarCount
import racingcar.domain.CarRace
import racingcar.domain.TrialCount
import racingcar.domain.record.RaceRecord

class CarRaceTest : AnnotationSpec() {
    @Test
    fun `CarRace는 각 경기에 대한 모든 자동차의 위치 정보를 알려준다`() {
        // given
        val carRace = CarRace()
        val carCount = CarCount(3)
        val trialCount = TrialCount(2)

        // when
        val raceResult: RaceRecord = carRace.start(carCount, trialCount)

        // then
        raceResult.record.size shouldBe 2
        raceResult.record[0].positions.size shouldBe 3
        raceResult.record[1].positions.size shouldBe 3
    }
}
