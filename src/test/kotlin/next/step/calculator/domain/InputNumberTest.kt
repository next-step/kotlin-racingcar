package next.step.calculator.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class InputNumberTest : FunSpec({
    test("문자열로 입력 숫자 생성") {
        InputNumber.from("123") shouldBe InputNumber(123)
    }

    context("공백으로 입력 숫자 생성시 예외 발생") {
        withData(
            nameFn = { "\"${it}\"" },
            listOf("", " ", "      ")
        ) { spaces ->
            shouldThrow<IllegalArgumentException> {
                InputNumber.from(spaces)
            }
        }
    }

    context("공백이 아니면서 숫자가 아닌 문자열로 입력 숫자 생성시 예외 발생") {
        withData(
            nameFn = { "\"${it}\"" },
            "dfd", "한글", "+"
        ) { notNumber ->
            shouldThrow<IllegalArgumentException> {
                InputNumber.from(notNumber)
            }
        }
    }

    test("입력 숫자 합") {
        InputNumber(10) + InputNumber(20) shouldBe InputNumber(30)
    }

    test("입력 숫자 차이") {
        InputNumber(10) - InputNumber(20) shouldBe InputNumber(-10)
    }

    test("입력 숫자 곱") {
        InputNumber(10) * InputNumber(20) shouldBe InputNumber(200)
    }

    test("입력 숫자 나누기") {
        InputNumber(20) / InputNumber(10) shouldBe InputNumber(2)
    }
})
