package calculator

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows

class NumberTest : FunSpec({

    context("연산을 처리한다.") {
        test("덧셈(+)") {
            Number(1) + Number(3) shouldBe Number(4)
        }

        test("뺄셈(-)") {
            Number(7) - Number(2) shouldBe Number(5)
        }

        test("곱셈(*)") {
            Number(10) * Number(2) shouldBe Number(20)
        }

        test("나누셈(/)") {
            Number(10) / Number(2) shouldBe Number(5)
        }
    }

    test("0으로는 나눌 수 없다.") {
        assertThrows<IllegalArgumentException> { Number(10) / Number.ZERO }
    }
})
