package step2

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class CalculatorTest: AnnotationSpec() {
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
}
