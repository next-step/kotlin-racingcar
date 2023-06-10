package racing.application

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldBeIn
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import racing.domain.Capacity
import racing.domain.Cars
import racing.domain.DirectionType
import racing.domain.Distance
import racing.domain.Name

class RacingServiceTest : BehaviorSpec({
    Given("racing 메서드를 호출할 때 ") {
        When("전진 전략이 항상 전진을 반환하고") {
            val racingService = RacingService { DirectionType.STRAIGHT }

            And("유효한 횟수와 자동차 참가자를 인자로 전달할 경우 ") {
                val info = RacingInfo(round = Capacity(5), cars = Cars("a,b,c,d,e"))
                val actual = racingService.racing(info)

                Then("전달받은 자동차 대수만큼 자동차를 생성하고 결과를 반환한다.") {
                    actual.racingHistories shouldHaveSize 5
                    actual.racingHistories.mapIndexed { idx, info ->
                        info.records.forEach {
                            it.value shouldBe Distance(idx + 1L)
                        }
                    }
                    actual.winners shouldBe arrayOf(Name("a"),Name("b"),Name("c"),Name("d"),Name("e"))
                }
            }
        }
    }
})
