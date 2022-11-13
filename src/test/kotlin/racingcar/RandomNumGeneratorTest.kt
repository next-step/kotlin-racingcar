package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.ints.shouldBeInRange
import racingcar.domain.RandomNumGenerator

class RandomNumGeneratorTest : BehaviorSpec({

    val (min, max) = 0 to 9
    Given("최솟값은 0, 최댓값은 9이고") {
        When("랜덤 숫자를 생성하면") {
            Then("0과 9 사이의 랜덤 숫자가 생성된다.") {
                RandomNumGenerator.generate(min, max) shouldBeInRange (min..max)
            }
        }
    }
})
