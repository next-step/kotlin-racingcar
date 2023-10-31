package calculator.operator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SimpleFourBasicOperationTest {
    private val operation = SimpleFourBasicOperation
    @Test
    fun addTest() {
        assertThat(operation.add(3.0, 4.0)).isEqualTo(7.0)
        assertThat(operation.add(14.0, 7.0)).isEqualTo(21.0)
        assertThat(operation.add(0.0, 9.0)).isEqualTo(9.0)
    }

    @Test
    fun subtractTest() {
        assertThat(operation.subtract(3.0, 4.0)).isEqualTo(-1.0)
        assertThat(operation.subtract(14.0, 7.0)).isEqualTo(7.0)
        assertThat(operation.subtract(0.0, 9.0)).isEqualTo(-9.0)
    }

    @Test
    fun multiplyTest() {
        assertThat(operation.multiply(3.0, 4.0)).isEqualTo(12.0)
        assertThat(operation.multiply(14.0, 7.0)).isEqualTo(98.0)
        assertThat(operation.multiply(0.0, 9.0)).isEqualTo(0.0)
    }

    @Test
    fun divideTest() {
        assertThat(operation.divide(8.0, 4.0)).isEqualTo(2.0)
        assertThat(operation.divide(15.0, 6.0)).isEqualTo(2.5)
        assertThat(operation.divide(0.0, 9.0)).isEqualTo(0.0)
    }
}
