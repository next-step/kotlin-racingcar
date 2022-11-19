package racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk

class RaceKoTest : BehaviorSpec({
    given("레이싱 자동차 게임") {
        val raceSetting = mockk<RaceSetting>()

        `when`("자동차 대수와") {
            every { raceSetting.numberOfCar } returns 4

            and("시도할 횟수를 선택하면") {
                every { raceSetting.totalCountOfRound } returns 3

                and("경기를 시작할 수 있다.") {
                    val race = Race(raceSetting)
                    val raceResult = race.run()

                    then("그리고 경기 결과가 도출된다.") {
                        val groupedRaceResult = raceResult.groupByRound()
                        groupedRaceResult.size shouldBe raceSetting.totalCountOfRound
                        groupedRaceResult[0]?.size shouldBe raceSetting.numberOfCar
                    }
                }
            }
        }
    }
})
