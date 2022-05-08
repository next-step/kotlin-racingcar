package step2.calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class NumberPairTest {

    @Test
    fun `NumberPair 객체생성 테스트`() {
        val numberPair = NumberPair.of("1", "2")

        assertThat(numberPair.first).isEqualTo(1.0)
        assertThat(numberPair.second).isEqualTo(2.0)
    }
}
