package racing.application

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import racing.domain.Capacity
import racing.domain.Distance

class RacingServiceTest : BehaviorSpec({
    given("racing 메서드를 호출할 때 ") {
        `when`("전진 전략이 항상 참을 반환하고") {
            val racingService = RacingService { true }

            and("유효한 횟수와 자동차 대수를 인자로 전달할 경우 ") {
                val info = RacingInfo(round = Capacity(5), capacity = Capacity(5))
                val actual = racingService.racing(info)

                then("전달받은 자동차 대수만큼 자동차를 생성하고 결과를 반환한다.") {
                    actual shouldHaveSize 5
                    actual.mapIndexed { idx, info ->
                        info.records.forEach {
                            it.value shouldBe Distance(idx + 1L)
                        }
                    }
                }
            }
        }
    }
})
