package racingcar.domain

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
})
