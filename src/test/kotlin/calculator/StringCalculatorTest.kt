package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class StringCalculatorTest : FunSpec({
    context("StringCalculator 테스트") {
        context("예외 시나리오") {
            test(" '', ' ', null 등 공백 입력값은 예외 발생") {
                // given
                forAll(
                    row(""),
                    row(" "),
                    row(null)
                ) {
                    // when, then
                    shouldThrow<IllegalArgumentException> {
                        StringCalculator(it).run()
                    }
                }
            }
            test("숫자 자리에 정수 이외의 입력값 -> 예외 발생") {
                // given
                forAll(
                    row("0.5 + 1"),
                    row("1 + b"),
                    row("100 + *123")
                ) {
                    // when, then
                    shouldThrow<IllegalArgumentException> {
                        StringCalculator(it).run()
                    }
                }
            }
            test("연산자 자리에 사칙연산 이외의 기호 -> 예외 발생") {
                // given
                forAll(
                    row("1 ^ 2"),
                    row("1 + 2 ) 3")
                ) {
                    // when, then
                    shouldThrow<IllegalArgumentException> {
                        StringCalculator(it).run()
                    }
                }
            }
            test("각 입력값 사이에 공백이 한 개씩만 존재하지 않는 경우 -> 예외 발생") {
                // given
                forAll(
                    row("1 +  2"),
                    row("1 + 2+3")
                ) {
                    // when, then
                    shouldThrow<IllegalArgumentException> {
                        StringCalculator(it).run()
                    }
                }
            }
            test("0으로 나누는 경우 -> 예외 발생") {
                // given
                val input = "16 + 5 / 0"
                // when then
                shouldThrow<IllegalArgumentException> {
                    StringCalculator(input).run()
                }
            }
        }
        context("정상 시나리오") {
            test("정상적인 이항 계산 수행") {
                // given
                forAll(
                    row("1 + 2", 3),
                    row("3 * 6", 18),
                    row("12 / 3", 4)
                ) { input, expected ->
                    // when
                    val result = StringCalculator(input).run()
                    // then
                    result shouldBe expected
                }
            }
            test("정상적인 다항 계산 수행") {
                // given
                forAll(
                    row("1 + 2 / 1", 3),
                    row("3 * 6 + 3", 21),
                    row("12 - 3 / 3", 3),
                    row("1 + 2 + 3 + 4 + 5", 15)
                ) { input, expected ->
                    // when
                    val result = StringCalculator(input).run()
                    // then
                    result shouldBe expected
                }
            }
        }
    }
})
