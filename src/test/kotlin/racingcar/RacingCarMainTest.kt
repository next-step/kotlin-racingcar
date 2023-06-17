package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class RacingCarMainTest : BehaviorSpec({
    Given("자동차 이름은 쉼표(,)를 기준으로 구분한다.") {
        When("자동차 이름이 n개와 쉼표(,)로 구성된 문자열 입력이 들어온다.") {
            listOf(
                "pobi,crong,honux",
                "pobi,crong"
            ).forAll {
                Then("각각의 이름을 가진 자동차 n개가 생성된다.") {
                    val racingCars = RacingCars(it)
                    val inputs = it.split(",")

                    racingCars.cars.size shouldBe inputs.size
                    (racingCars.cars.indices).forEach {
                        racingCars.cars[it].name shouldBe inputs[it]
                    }
                }
            }
        }
    }
})
