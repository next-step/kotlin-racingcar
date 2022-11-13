package racingcar.util

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingcar.const.CarException
import java.lang.IllegalArgumentException

internal class ParserTest : BehaviorSpec({
    Given(",로 구분되어 지는 자동차 이름으로 된 문자열이 주어지면, ") {
        val expected = listOf("car1", "car2", "car3")

        val givenForFirstTest = "car1,car2,car3"
        When("파싱을 진행하면, ") {
            Then("자동차 이름들이 각각 나온다.") {
                Parser.parse(givenForFirstTest) shouldBe expected
            }
        }

        val givenForSecondTest = "car1,   car2,  car3"
        When("공백이 존재해도 파싱을 진행하면, ") {
            Then("자동차 이름들이 각각 나온다.") {
                Parser.parse(givenForSecondTest) shouldBe expected
            }
        }

        val givenFOrThirdTest = null
        When("null이 들어오면, ") {
            Then("예외를 반환한다.") {
                val exception = shouldThrow<IllegalArgumentException> {
                    Parser.parse(givenFOrThirdTest) shouldBe expected
                }
                exception.message shouldBe CarException.NULL_INPUT_ERROR
            }
        }

        val givenForFourthTest = ""
        When("빈 값이 들어오면, ") {
            Then("예외를 반환한다.") {
                val exception = shouldThrow<IllegalArgumentException> {
                    Parser.parse(givenForFourthTest) shouldBe expected
                }
                exception.message shouldBe CarException.NULL_INPUT_ERROR
            }
        }
    }
})
