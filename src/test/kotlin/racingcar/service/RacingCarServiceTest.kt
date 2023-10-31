package racingcar.service

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import io.kotest.matchers.shouldBe

class RacingCarServiceTest : BehaviorSpec({
    given("자동차 경주에 필요한 정보를 받아온다.") {
        val carNames = "car1,car2,car3".split(",")
        val operableCount = 5
        val racingCarService = RacingCarService(carNames, operableCount)
        `when`("자동차 경주를 시작한다.") {
            val racingCarResult = racingCarService.startRacing()
            then("자동차 경주 결과를 반환한다.") {
                racingCarResult.carsList.size shouldBe operableCount
                racingCarResult.winners.size shouldBeGreaterThanOrEqual 1
            }
        }
    }
})
