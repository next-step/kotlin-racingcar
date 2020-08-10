package calculator.util

import calculator.calculator.TextCalculator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UtilTest {
    @Test
    fun `isOdd() 테스트`() {
        assertThat(1.isOdd()).isTrue()
        assertThat(2.isOdd()).isFalse()
    }

    @Test
    fun `subListStartWith() 테스트`() {
        TextCalculator().apply {
            assertThat(listOf(1, 2, 3).subListStartWith(0, 1)).isEqualTo(listOf(0, 2, 3))
        }
    }

    @Test
    fun `subListAfter() 테스트`() {
        TextCalculator().apply {
            assertThat(listOf(1, 2, 3).subListAfter(1)).isEqualTo(listOf(2, 3))
        }
    }
}
