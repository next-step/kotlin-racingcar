package racingcar.util

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.ints.shouldBeLessThan

class RandomNumGeneratorTest : BehaviorSpec({

    Given("getNextInt 메서드는") {
        val randomNumGenerator = RandomNumGenerator()
        When("내부에 정의된 bound를 통해") {
            Then("0 이상 bound 미만의 숫자만 생성한다.") {
                randomNumGenerator.getNextInt() shouldBeLessThan 10
            }
        }
    }
})
