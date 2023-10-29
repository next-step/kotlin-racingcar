package step3_4.racing.car

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.ints.shouldBeLessThan
import step3_4.racing.Car
import step3_4.racing.CarRacing
import kotlin.random.Random.Default.nextInt

class CarRacingTest : BehaviorSpec({
    Given("CarRacing 객체에서 사용된 nextInt 함수는") {
        When("파라미터에 from 0, until 10을 주면") {
            Then("until 미만의 값만 나온다") {
                nextInt(from = 0, until = 10) shouldBeLessThan 10
            }
        }
    }
    Given("중복 된 요소를 갖고 있는 경우") {
        val given = listOf(Car("pita"), Car("pita"), Car("haero"))
        val exampleRound = 3
        val expectedMessage = "중복 요소가 존재 합니다"
        When("중복 요소로 CarRacing 객체를 만들면") {
            Then("중복 에러를 던진다") {
                shouldThrowWithMessage<IllegalStateException>(expectedMessage) {
                    CarRacing(given, exampleRound)
                }
            }
        }
    }
})
