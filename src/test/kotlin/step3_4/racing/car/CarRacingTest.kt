package step3_4.racing.car

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.ints.shouldBeLessThan
import kotlin.random.Random.Default.nextInt

class CarRacingTest : BehaviorSpec({
    Given("CarRacing 객체에서 사용된 nextInt 함수는") {
        When("파라미터에 from 0, until 10을 주면") {
            Then("until 미만의 값만 나온다") {
                nextInt(from = 0, until = 10) shouldBeLessThan 10
            }
        }
    }
})
