package calculator

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class CPUTest : StringSpec({

    "3 더하기 2는 5" {
        CPU().add(3, 2) shouldBe 5
    }

    "3 빼기 2는 1이다" {
        CPU().subtract(3, 2) shouldBe 1
    }

    "3 곱하기 2는 6이다" {
        CPU().multiply(3, 2) shouldBe 6
    }

    "나눗셈 결과 소수점이 있으면 버린다" {
        CPU().divide(3, 2) shouldBe 1
    }

    "나눗셈 결과 소수점이 없다면 기존과 동일한 값이 나온다" {
        CPU().divide(4, 2) shouldBe 2
    }

    "0으로 나누면 ArithmeticException(/ by zero) 예외가 발생한다" {
        shouldThrowWithMessage<ArithmeticException>("/ by zero") {
            CPU().divide(4, 0)
        }
    }
})
