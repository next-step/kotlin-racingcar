package stringcalculator.OperatorTests

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import stringcalculator.Operational
import stringcalculator.Operator

class SubtractTest {

    @ParameterizedTest
    @CsvSource(*["2, 1", "1, 2"])
    fun `execute 시 두 값의 차를 구한 결과를 리턴한다`(left: Int, right: Int) {
        val operational = Operational(left, right)

        val result = Operator.SUBTRACT.execute(operational)

        assertThat(result).isEqualTo(left - right)
    }
}
