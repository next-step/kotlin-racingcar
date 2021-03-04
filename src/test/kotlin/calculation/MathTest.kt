package calculation

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MathTest {
    @Test
    fun `두 수의 합`() {
        assertThat(Calculation("3 + 4")).isEqualTo(7)
    }

    @Test
    fun `두 수의 차`() {
        assertThat(Calculation("4 - 1")).isEqualTo(3)
    }

    @Test
    fun `두 수의 곱`() {
        assertThat(Calculation("4 * 3")).isEqualTo(12)
    }

    @Test
    fun `두 수의 몫`() {
        assertThat(Calculation("4 / 2")).isEqualTo(2)
    }

    @Test
    fun `예약되지 않은 연산자`() {
        assertThrows<IllegalArgumentException> { Calculation("4 $ 2") }
    }

    @Test
    fun `계산식이 없는 경우`() {
        assertThrows<IllegalArgumentException> { Calculation("") }
    }

    @Test
    fun `계산식이 비정상인 경우`() {
        assertThrows<IllegalArgumentException> { Calculation("1 1") }
    }

    @Test
    fun `0으로 나누는 경우`() {
        assertThrows<IllegalArgumentException> { Calculation("1 / 0").toInt() }
    }

    @Test
    fun `세 수의 합`() {
        assertThat(Calculation("3 + 4 + 5")).isEqualTo(12)
    }

    @Test
    fun `합 차 곱 몫 조합`() {
        assertThat(Calculation("2 + 3 * 4 / 2")).isEqualTo(10)
    }
}
