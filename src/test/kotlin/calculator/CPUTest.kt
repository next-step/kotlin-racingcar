package calculator

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class CPUTest : StringSpec({

    "3 + 2 = 5" {
        CPU().add(3, 2) shouldBe 5
    }

    "3 - 2 = 1" {
        CPU().subtract(3, 2) shouldBe 1
    }

    "3 * 2 = 6" {
        CPU().multiply(3, 2) shouldBe 6
    }

    "3 / 2 = 1" {
        CPU().divide(3, 2) shouldBe 1
    }

    "4 / 2 = 2" {
        CPU().divide(4, 2) shouldBe 2
    }

    // 함수명에 /(Slash)를 넣고 싶은데 안되서 JUnit말고 kotest를 사용했습니다.
    "4 / 0 = ArithmeticException(\"/ by zero\")" {
        shouldThrowWithMessage<ArithmeticException>("/ by zero") {
            CPU().divide(4, 0)
        }
    }
})
