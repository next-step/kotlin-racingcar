package stringcalculator.OperatorTests

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import stringcalculator.Operational
import stringcalculator.Operator

class AddTest {
    @Test
    fun `execute 시 두 값을 더한 결과를 리턴한다`() {
        val operational = Operational(1, 2)

        val result = Operator.ADD.execute(operational)

        assertThat(result).isEqualTo(1 + 2)
    }
}
