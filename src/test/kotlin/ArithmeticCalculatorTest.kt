import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class ArithmeticCalculatorTest : BehaviorSpec({

    with(ArithmeticCalculator()) {
        Given("문자열이 입력 되었을 때") {
            When("문자열이 null 이거나 비어있으면") {
                Then("IllegalArgumentException 에러가 발생한다") {
                    shouldThrow<IllegalArgumentException> { execute(null) }
                    shouldThrow<IllegalArgumentException> { execute("") }
                }
            }

            When("문자열의 수가 3개 미만이면") {
                Then("IllegalArgumentException 에러가 발생한다") {
                    shouldThrow<IllegalArgumentException> { execute("1") }
                    shouldThrow<IllegalArgumentException> { execute("1 +") }
                    shouldThrow<IllegalArgumentException> { execute("/ 1") }
                    shouldThrow<IllegalArgumentException> { execute("1 *") }
                }
            }

            When("문자열의 수가 짝수이면") {
                Then("IllegalArgumentException 에러가 발생한다") {
                    shouldThrow<IllegalArgumentException> { execute("1 + 1 1") }
                    shouldThrow<IllegalArgumentException> { execute("1 + + 1") }
                    shouldThrow<IllegalArgumentException> { execute("1 + 1 * 2 /") }
                }
            }

            When("숫자 자리에 기호가 존재하면") {
                Then("NumberFormatException 에러가 발생한다") {
                    shouldThrow<NumberFormatException> { execute("1 + -") }
                    shouldThrow<NumberFormatException> { execute("1 + 2 / /") }
                    shouldThrow<NumberFormatException> { execute("1 / 2 * 3 - -") }
                }
            }

            When("기호 자리에 숫자가 존재하면") {
                Then("IllegalArgumentException 에러가 발생한다") {
                    shouldThrow<IllegalArgumentException> { execute("1 * 1 / 1 1 1") }
                    shouldThrow<IllegalArgumentException> { execute("1 1 1") }
                    shouldThrow<IllegalArgumentException> { execute("1 + 3 1 2") }
                }
            }

            When("숫자 자리에 숫자가 아닌 문자열이 존재하면") {
                Then("NumberFormatException 에러가 발생한다") {
                    shouldThrow<NumberFormatException> { execute("a + 1") }
                    shouldThrow<NumberFormatException> { execute("1 + a") }
                    shouldThrow<NumberFormatException> { execute("a + a") }
                }
            }

            When("기호 자리에 사칙 연산 기호가 아닌 다른 문자열이 존재하면") {
                Then("IllegalArgumentException 에러가 발생한다") {
                    shouldThrow<IllegalArgumentException> { execute("1 ? 1") }
                    shouldThrow<IllegalArgumentException> { execute("1 . 2") }
                    shouldThrow<IllegalArgumentException> { execute("1 _ 3") }
                    shouldThrow<IllegalArgumentException> { execute("1 + 3 a 4") }
                }
            }

            When("공백이 존재 하더라도 올바른 수식 문자열이면") {
                Then("연산 결과를 반환한다") {
                    execute("1 + 1") shouldBe 2.0
                    execute("1 + 1 + 1") shouldBe 3.0
                    execute("1 -   1") shouldBe 0.0
                    execute(" -1 - 1") shouldBe -2.0
                    execute("-1 * 1   ") shouldBe -1.0
                    execute("-1 /     2") shouldBe -0.5
                    execute("0 /  0") shouldBe Double.NaN
                    execute("1 +    2 * 3 / 3 - 10") shouldBe -7.0
                    execute("1 +  2 * 3   / 3 - 10") shouldBe (((1 + 2) * 3) / 3) - 10
                    execute("10 * 10 / 5 - 20 / 0") shouldBe Double.NaN
                }
            }
        }
    }
})
