package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class RacingCarTest : BehaviorSpec({

    Given("자동차는 위치 값을 가진다.") {
        When("자동차가 위치 값이 들어오면서 생성될떄") {
            listOf(
                3, 10
            ).forAll {
                val racingCar = RacingCar(it)
                Then("들어오는 값으로 위치 값이 생성되어야한다.") {
                    racingCar.position shouldBe it
                }
            }
        }
        When("자동차를 위치값 없이 생성될때.") {
            val racingCar = RacingCar()
            Then("위치값이 0이여야 한다.") {
                racingCar.position shouldBe 0
            }
        }
    }

    val racingCar = RacingCar()
    Given("들어오는 값이 0~9 이다.") {
        When("주어진 값이 4이상일떄") {
            racingCar.tryMove(4)
            Then("자동차의 위치값이 1증가한다.")
            racingCar.position shouldBe 1
        }
    }
})
