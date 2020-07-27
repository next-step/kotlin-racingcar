package step2

import org.assertj.core.api.Assertions.assertThat
// import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

// import org.junit.jupiter.api.assertAll

class CalculatorTest {
    @Test
    @DisplayName("연산 체크")
    fun checkOperate() {
        assertThat(Operate.SUM.cal(4, 4)).isEqualTo(4 + 4)
        assertThat(Operate.SUB.cal(4, 4)).isEqualTo(4 - 4)
        assertThat(Operate.MUL.cal(4, 4)).isEqualTo(4 * 4)
        assertThat(Operate.DIV.cal(4, 4)).isEqualTo(4 / 4)
    }
}
