package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class RacingCarTest : BehaviorSpec({

    Given("레이서는") {
        When("숫자가 입력받았을 때") {
            Then("4 이상이면 전진하고, 4 미만이면 정지한다.") {
                forAll(
                    row(0, 0),
                    row(1, 0),
                    row(2, 0),
                    row(3, 0),
                    row(4, 1),
                    row(5, 1),
                    row(6, 1),
                    row(7, 1),
                    row(8, 1),
                    row(9, 1)
                ) { num, expected ->
                    RacingCar("pobi").moveOrStop(num).position shouldBe expected
                }
            }
        }
    }

    Given("공백이나 5글자가 넘는 이름을 입력받으면") {
        When("레이싱카를 생성할 때") {
            Then("에러가 발생한다.") {
                forAll(
                    row("yeong1"),
                    row(""),
                    row(" ")
                ) { name ->
                    shouldThrow<IllegalArgumentException> {
                        RacingCar(name)
                    }
                }
            }
        }
    }

    Given("위치가 주어지면") {
        When("레이싱카는") {
            val racingCar = RacingCar("pobi", 3)
            Then("자신의 위치와 같은지를 판단한다.") {
                forAll(
                    row(0, false),
                    row(1, false),
                    row(2, false),
                    row(3, true),
                    row(4, false),
                ) { position, expected ->
                    racingCar.isSamePosition(position) shouldBe expected
                }
            }
        }
    }
})
