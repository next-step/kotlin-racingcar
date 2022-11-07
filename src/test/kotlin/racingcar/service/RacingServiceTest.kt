package racingcar.service

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class RacingServiceTest : BehaviorSpec({
    val racingService = RacingService()

    given("자동차 대수를") {
        `when`("입력했을 때") {
            listOf(3, 5, 8).forAll {
                then("입력값 만큼 자동차 객체가 생성되야 한다.") {
                    racingService.makeCar(it).size shouldBe it
                }
            }
        }
    }
})
