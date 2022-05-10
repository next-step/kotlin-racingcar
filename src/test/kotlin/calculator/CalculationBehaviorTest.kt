package calculator

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class CalculationBehaviorTest : BehaviorSpec({
    var actual: Result

    Given("문자열 계산기가") {
        When("단순 더하기만 있는 식") {
            forAll(
                row("1 + 10 + 20", 31),
                row("2 + 30", 32),
            ) { input, expected ->
                actual = StringCalculator.calculate(input)
                Then("${input}을 잘 계산한다") {
                    actual.value shouldBe expected
                }
            }
        }

        When("단순 빼기만 있는 식") {
            forAll(
                row("30 - 10 - 20", 0),
                row("9 - 18", -9),
            ) { input, expected ->
                actual = StringCalculator.calculate(input)
                Then("${input}을 잘 계산한다") {
                    actual.value shouldBe expected
                }
            }
        }

        When("단순 곱하기만 있는 식") {
            forAll(
                row("7 * 10 * 1", 70),
                row("1 * 1", 1),
                row("9999 * 0", 0),
            ) { input, expected ->
                actual = StringCalculator.calculate(input)
                Then("${input}을 잘 계산한다") {
                    actual.value shouldBe expected
                }
            }
        }

        When("단순 나누기만 있는 식") {
            forAll(
                row("30 / 5 / 2", 3),
                row("1 / 1", 1),
            ) { input, expected ->
                actual = StringCalculator.calculate(input)
                Then("${input}을 잘 계산한다") {
                    actual.value shouldBe expected
                }
            }
        }

        When("복잡한 사칙연산이 있는 식") {
            forAll(
                row("10 + 2 / 6 * 3 - 90 * -20", 1680),
                row("-1 * 1 + 2 / 1", 1),
                row("2 + 3 * 4 / 2", 10),
                row("3.9 / 3 + 5", 6.3),
            ) { input, expected ->
                actual = StringCalculator.calculate(input)
                Then("${input}을 잘 계산한다") {
                    actual.value shouldBe expected
                }
            }
        }

        When("입력 값이 null 인 경우") {
            then("IllegalArgumentException 을 발생한다") {
                shouldThrowExactly<IllegalArgumentException> {
                    StringCalculator.calculate(null)
                }
            }
        }

        When("입력 값이 공백인 경우") {
            forAll(
                row(""),
                row(" "),
                row("   "),
            ) { input ->
                then("IllegalArgumentException 을 발생한다 (공백: ${input.length}") {
                    shouldThrowExactly<IllegalArgumentException> {
                        StringCalculator.calculate(input)
                    }
                }
            }
        }

        When("사칙연산이 아닌 기호과 포함되어 있는 경우") {
            forAll(
                row("4 / 2 $ 3"),
                row("1 gsad adsf"),
                row("a + b - c"),
            ) { input ->
                then("IllegalArgumentException 을 발생한다 (식: $input)") {
                    shouldThrowExactly<IllegalArgumentException> {
                        StringCalculator.calculate(input)
                    }
                }
            }
        }

        When("항이 부족한 경우") {
            forAll(
                row("4 / 2 $"),
                row("1 +"),
            ) { input ->
                then("IllegalArgumentException 을 발생한다 (식: $input)") {
                    shouldThrowExactly<IllegalArgumentException> {
                        StringCalculator.calculate(input)
                    }
                }
            }
        }

        When("나누기에 0이 포함된 경우") {
            forAll(
                row("1 / 0"),
                row("0 / 1"),
            ) { input ->
                then("IllegalArgumentException 을 발생한다 (식: $input)") {
                    shouldThrowExactly<IllegalArgumentException> {
                        StringCalculator.calculate(input)
                    }
                }
            }
        }
    }
})
