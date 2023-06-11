package racing.application

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import racing.domain.DirectionType
import racing.domain.Distance
import racing.domain.Name
import racing.domain.dto.RacingGameRequest

class RacingServiceTest : BehaviorSpec({
    Given("유효한 횟수와 자동차 참가자가 제공된다.") {
        val info = RacingGameRequest(numberOfRound = 5, carNames = listOf("a", "b", "c", "d", "e"))

        And("전진 전략이 항상 전진을 반환한다.") {
            val racingService = RacingService { DirectionType.STRAIGHT }

            When("경주를 진행 했을 경우") {
                val actual = racingService.racing(info)

                Then("전달받은 자동차 대수만큼 자동차를 생성하고 결과를 반환한다.") {
                    actual.racingHistories shouldHaveSize 5
                    actual.racingHistories.mapIndexed { idx, info ->
                        info.records.forEach {
                            it.value shouldBe Distance(idx + 1L)
                        }
                    }
                    actual.winners shouldBe arrayOf(Name("a"), Name("b"), Name("c"), Name("d"), Name("e"))
                }
            }
        }
    }
})
