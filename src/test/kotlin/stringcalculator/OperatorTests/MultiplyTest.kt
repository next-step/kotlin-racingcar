package stringcalculator.OperatorTests

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import stringcalculator.Operational
import stringcalculator.Operator

class MultiplyTest {
    @Test
    fun `execute 실행 시 두 값을 꺼내 곱한 결과를 리턴한다`() {
        val operational = Operational(2, 3)

        val result = Operator.MULTIPLY.execute(operational)

        assertThat(result).isEqualTo(2 * 3)
    }
}
