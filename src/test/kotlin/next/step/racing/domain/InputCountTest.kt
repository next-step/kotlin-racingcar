package next.step.racing.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class InputCountTest : FunSpec({
    test("문자열로 입력 숫자 생성") {
        InputCount.from("123") shouldBe InputCount(123)
    }

    context("공백으로 입력 숫자 생성시 예외 발생") {
        withData(
            nameFn = { "\"${it}\"" },
            listOf("", " ", "      ")
        ) { spaces ->
            shouldThrow<IllegalArgumentException> {
                InputCount.from(spaces)
            }
        }
    }

    context("공백이 아니면서 숫자가 아닌 문자열로 입력 숫자 생성시 예외 발생") {
        withData(
            nameFn = { "\"${it}\"" },
            "dfd", "한글", "+"
        ) { notNumber ->
            shouldThrow<IllegalArgumentException> {
                InputCount.from(notNumber)
            }
        }
    }

    context("양수가 아닌 입력 숫자 생성시 예외 발생") {
        withData(
            nameFn = { "\"${it}\"" },
            listOf("-100", "-10", "0")
        ) { spaces ->
            shouldThrow<IllegalArgumentException> {
                InputCount.from(spaces)
            }
        }
    }
})
