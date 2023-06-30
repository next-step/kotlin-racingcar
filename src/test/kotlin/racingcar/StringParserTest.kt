package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldContainAll

class StringParserTest : BehaviorSpec({
    Given("자동차 이름은 쉼표(,)를 기준으로 구분한다.") {
        When("자동차 이름이 n개와 쉼표(,)로 구성된 문자열 입력이 들어온다.") {
            val racingCars = StringParser.parseRacingCarString("pobi,crong,honux")
            Then("각각의 이름을 가진 자동차 n개가 생성된다.") {
                racingCars shouldContainAll listOf(RacingCar("pobi"), RacingCar("crong"), RacingCar("honux"))
            }
        }
    }
})
