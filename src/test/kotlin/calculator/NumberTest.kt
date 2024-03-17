package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class NumberTest: ShouldSpec({

    should("Number는 문자열을 받아 Double형 숫자로 저장한다") {
        Number.fromString("1").number shouldBe 1.0
    }

    should("Number는 문자열이 숫자가 아닐 경우 IllegalArgumentException을 던진다") {
        val exception = shouldThrow<IllegalArgumentException> {
            Number.fromString("a")
        }
        exception.message shouldBe "a is not a number."
    }

    should("isNumeric은 문자열이 숫자인지 판별한다") {
        Number.isNumeric("1") shouldBe true
        Number.isNumeric("a") shouldBe false
    }
})