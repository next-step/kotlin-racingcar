package step2

import io.kotest.core.spec.style.Test

class CalculatorTest {
    @Test
    fun `+연산자는 좌우 숫자를 합산한다`() {
        val sut = Calculator()

        val result = sut.calculate("3 + 4")

        result shouldBe 7
    }
}
