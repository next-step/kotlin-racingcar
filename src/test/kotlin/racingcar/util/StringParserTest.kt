package racingcar.util

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldContainAll
import racingcar.domain.car.RacingCar

class StringParserTest : BehaviorSpec({
    Given("자동차 이름은 쉼표(,)를 기준으로 구분한다.") {
        When("자동차 이름이 n개와 쉼표(,)로 구성된 문자열 입력이 들어온다.") {
            val racingCars = StringParser.parseRacingCarString("pobi,crong,honux")
            Then("각각의 이름을 가진 자동차 n개가 생성된다.") {
                racingCars shouldContainAll listOf(RacingCar.of("pobi"), RacingCar.of("crong"), RacingCar.of("honux"))
            }
        }
    }

    Given("시도하는 횟수가 0 보다 작은 숫자나 공백이 들어오면 에러") {
        When("0보다 작은 숫자나 공백이 들어온다.") {
            listOf("-1", "^^", "")
                .forAll {
                    Then("IllegalArgumentException 이 발생한다.") {
                        shouldThrow<IllegalArgumentException> {
                            StringParser.getIntValue(it)
                        }
                    }
                }
        }
    }
})
