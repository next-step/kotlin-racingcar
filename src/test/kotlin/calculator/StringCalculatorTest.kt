package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class StringCalculatorTest : StringSpec({

    "숫자,기호,숫자 순서로 입력된 문자열은 정상적으로 계산한다." {
        val inputs = listOf(
            "5 - 1 + 3 * 10 / 2" to 35,
            "1 - 11 + 0 / 2 * 5" to -25,
            "10 / 2 + 3 * 5 - 39" to 1,
            "1 + 3" to 4
        )
        inputs.map {
            val (input, output) = it
            StringCalculator.calc(input) shouldBe output
        }
    }

    "숫자,기호,숫자로 순서로 입력된 문자열이지만 나누기 연산에서 피연산자 중에서 0이 포함되어 있으면 예외를 던진다." {
        shouldThrow<IllegalArgumentException> {
            StringCalculator.calc("10 - 2 - 8 / 10")
        }.message shouldBe "나누기 연산에서 피연산자 중 0이 존재합니다."
    }

    "숫자,기호,숫자 순서가 아닌 문자열이 입력된다면 예외를 던진다." {
        val inputs = listOf(
            "1 + 2 * 10 *",
            "11 22",
            "* 1",
            "+",
            "-",
            "/",
            "*"
        )
        inputs.map {
            shouldThrow<IllegalArgumentException> {
                StringCalculator.calc(it)
            }.message shouldBe "유효하지 않은 입력입니다."
        }
    }
})
