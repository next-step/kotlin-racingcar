package calculator.model

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("연산자 테스트")
class OperatorTest {

    @Test
    fun `존재하지 않는 수식 기호 예외 발생`() {
        // given, when, then
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {
            Operator.findOperator('&')
        }
        Assertions.assertEquals("존재하지 않는 수식 기호입니다. (symbol: &)", exception.message)
    }

    @Test
    fun `나누는 수가 0일 때 예외 발생`() {
        // given, when, then
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {
            Operator.findOperator('/').operator(1, 0)
        }
        Assertions.assertEquals("나누는 수가 0이 될 수 없습니다.", exception.message)
    }
}
