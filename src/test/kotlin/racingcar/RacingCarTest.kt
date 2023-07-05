package racingcar

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class RacingCarTest : BehaviorSpec({

    Given("자동차는 이름과 위치 값을 가진다.") {
        When("자동차를 이름이 있고 위치값 없이 생성될때.") {
            val racingCar = RacingCar.of("자동차")
            Then("들어온 이름값과 위치값이 0이여야 한다.") {
                racingCar.name shouldBe "자동차"
                racingCar.position shouldBe 0
            }
        }
    }

    Given("자동차는 들어오는 값이 4이상일 경우 이동할 수 있다") {
        When("주어진 값이 4이상일떄") {
            listOf(4, 5, 6, 7, 8, 9).forAll {
                val racingCar = RacingCar.of("자동차")
                racingCar.tryMove()
                Then("자동차의 위치값이 1증가한다.") {
                    racingCar.position shouldBe 1
                }
            }
        }

        When("주어진 값이 4미만일떄") {
            listOf(0, 1, 2, 3).forAll {
                val racingCar = RacingCar.of("자동차")
                racingCar.tryMove()
                Then("자동차의 위치값이 증가하지 않는다.") {
                    racingCar.position shouldBe 0
                }
            }
        }
    }

    Given("자동차의 이름은 5글자를 넘는 경우 예외가 발생한다.") {
        When("자동차의 이름이 5글자를 넘을 경우") {
            shouldThrow<IllegalArgumentException> {
                RacingCar.of("다섯글자가넘는자동차")
            }
        }
    }
})
