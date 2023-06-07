import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class CalculatorTest : StringSpec({

    val calculator = Calculator()

    "피연산자의 수가 부족 하거나 정상적인 입력이 아닌 경우 IllegalArgumentException을 발생 시킨다" {
        forAll(
            row(""),
            row(" "),
            row(null),
            row("2 +"),
        ) { input ->
            val exception = shouldThrow<IllegalArgumentException> { calculator.calculate(input) }

            exception.message shouldBe "사칙연산을 할 수 없는 문자열입니다."
        }
    }

    "피연산자 자리에 숫자가 아닌 문자가 들어올 경우 IllegalArgumentException을 발생 시킨다" {
        forAll(
            row("2 + A"),
            row("2 + +"),
        ) { input ->
            val exception = shouldThrow<IllegalArgumentException> { calculator.calculate(input) }

            exception.message shouldBe "피연산자 자리에는 숫자가 와야합니다."
        }
    }

    "더하기 결과를 반환한다" {
        calculator.calculate("2 + 2") shouldBe 4
    }

    "빼기 결과를 반환한다" {
        calculator.calculate("4 - 2") shouldBe 2
    }

    "더하기 빼기의 사칙연산 결과를 반환한다" {
        calculator.calculate("5 + 4 - 2") shouldBe 7
        calculator.calculate("10 - 4 + 2") shouldBe 8
    }

    "곱하기 결과를 반환한다" {
        calculator.calculate("4 * 2") shouldBe 8
    }

    "더하기 빼기 곱하기의 사칙연산 결과를 반환한다" {
        calculator.calculate("4 * 2 - 10 + 9") shouldBe 7
    }

    "나누기 결과를 반환한다" {
        calculator.calculate("10 / 2") shouldBe 5
    }

    "사칙연산이 모두 포함 된 결과를 반환한다" {
        calculator.calculate("1 + 5 * 10 - 6 / 2") shouldBe 27
    }
})
