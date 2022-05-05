package step2

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class OperatorTest: AnnotationSpec() {

    @Test
    fun `+연산자는 두 숫자를 합한다`() {
        val sut = Operator.PLUS

        val result = sut.evaluate(3, 4)

        result shouldBe 7
    }
    @Test
    fun `-연산자는 두 숫자를 차감한다`() {
        val sut = Operator.MINUS

        val result = sut.evaluate(3, 4)

        result shouldBe -1
    }

    @Test
    fun `*연산자는 두 숫자를 곱셈한다`() {
        val sut = Operator.MULTIPLY

        val result = sut.evaluate(3, 4)

        result shouldBe 12
    }

}
