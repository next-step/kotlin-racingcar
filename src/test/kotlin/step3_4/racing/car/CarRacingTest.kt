package step3_4.racing.car

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.BehaviorSpec
import step3_4_5.domain.racing.Car
import step3_4_5.domain.racing.CarRacing

class CarRacingTest : BehaviorSpec({
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
