package racinggame.domain.car.engine

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class RandomEnergyEngineTest : BehaviorSpec({

    Given("엔진을 실행 했을 때") {
        When("랜덤 값이 4 미만이면") {
            (0..3).forEach { returnNumber ->
                Then("이동 가능 거리로 0을 반환한다") {
                    val mockRandomNumberGenerator = MockRandomNumberGenerator(returnNumber)
                    RandomEnergyEngine(mockRandomNumberGenerator).execute().value shouldBe 0
                }
            }
        }

        When("랜덤 값이 4 이상이면") {
            (4..10).forEach { returnNumber ->
                Then("이동 가능 거리로 1을 반환한다") {
                    val mockRandomNumberGenerator = MockRandomNumberGenerator(returnNumber)
                    RandomEnergyEngine(mockRandomNumberGenerator).execute().value shouldBe 1
                }
            }
        }
    }
})
