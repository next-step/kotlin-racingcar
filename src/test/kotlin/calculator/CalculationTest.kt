package calculator

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class CalculationTest : AnnotationSpec() {
    // TODO: 덧셈, 뺄셈, 곱셋, 나눗셈 테스트 작성
    // TODO: 입력값이 null or 공백인경우 IllegalArgumentException 이 발생하는지 확인
    // TODO: 사칙연산 기호가 아닌 경우 IllegalArgumentException 이 발생하는지 확인

    @Test
    fun `just plus calculation`() {
        // Given
        val calculator = StringCalculator()
        // When
        val actual = calculator.calculate("1 + 10 + 20")
        // Then
        actual shouldBe 31
    }

}
