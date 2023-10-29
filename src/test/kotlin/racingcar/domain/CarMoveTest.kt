package racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.util.Random

class CarMoveTest : BehaviorSpec({

    Given("CarMove 객체는") {
        val fourOrMoreGenerator = object: RandomGenerator<Int>(4, 9) {
            override fun generate(start: Int, end: Int): Int =
                IntRange(start, end).random()
        }
        val positiveCarMove = CarMove(fourOrMoreGenerator)
        When("4 이상의 정수가 나온다면") {
            Then("앞으로 전진할 수 있는지 확인하는 함수는 true를 반환한다.") {
                positiveCarMove.canMoveForward() shouldBe true
            }
        }

        val underFourGenerator = object: RandomGenerator<Int>(0, 3) {
            override fun generate(start: Int, end: Int): Int =
                IntRange(start, end).random()
        }
        val negativeCarMove = CarMove(underFourGenerator)
        When("4 미만의 정수가 나온다면") {
            Then("앞으로 전진할 수 있는지 확인하는 함수는 false를 반환한다.") {
                negativeCarMove.canMoveForward() shouldBe false
            }
        }
    }
})
