package step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OperatorTest {

    @Test
    fun add() {
        val adder = Adder(1, 1)
        val result = adder.calculate()

        assertThat(result).isEqualTo(2)
    }

    @Test
    fun subtract() {
        val subtractor = Subtractor(2, 1)
        val result = subtractor.calculate()

        assertThat(result).isEqualTo(1)
    }

    @Test
    fun multiply() {
        val multiplier = Multiplier(2, 2)
        val result = multiplier.calculate()

        assertThat(result).isEqualTo(4)
    }

    @Test
    fun divide() {
        val divider = Divider(4, 2)
        val result = divider.calculate()

        assertThat(result).isEqualTo(2)
    }
}
