package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : AnnotationSpec() {
    @Test
    fun `+연산자는 좌우 숫자를 계산한다`() {
        val sut = Calculator()

        val result = sut.calculate("3 + 4")

        result shouldBe 7
    }

    @Test
    fun `3개 이상의 숫자도 계산한다`() {
        val sut = Calculator()

        val result = sut.calculate("3 + 4 - 2")

        result shouldBe 5
    }

    @Test
    fun `Null 입력시 IllegalArgumentException 가 발생한다`() {
        val sut = Calculator()

        val exception = shouldThrow<IllegalArgumentException> {
            sut.calculate(null)
        }

        exception.message shouldBe "빈문자열은 입력될 수 없습니다."
    }
}
