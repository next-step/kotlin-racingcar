package study

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.InputStream

class CalculatorTest {
    companion object {
        val calculator = Calculator(0, 0)
    }

    @Test
    fun `add`() {
        val input = "2 + 3"
        val inputStream: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)

        calculator.start()

        assertThat(calculator.result).isEqualTo(5)
    }

    @Test
    fun `sub`() {
        val input = "6 - 3"
        val inputStream: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)

        calculator.start()

        assertThat(calculator.result).isEqualTo(3)
    }

    @Test
    fun `mul`() {
        val input = "4 * 3"
        val inputStream: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)

        calculator.start()

        assertThat(calculator.result).isEqualTo(12)
    }

    @Test
    fun `div`() {
        val input = "10 / 2"
        val inputStream: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)

        calculator.start()

        assertThat(calculator.result).isEqualTo(5)
    }

    @Test
    fun `total`() {
        val input = "2 + 3 - 1 * 4 / 2"
        val inputStream: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)

        calculator.start()

        assertThat(calculator.result).isEqualTo(8)
    }

    @Test
    fun `null check`() {
        val input = ""
        val inputStream: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)

        assertThatIllegalArgumentException().isThrownBy {
            calculator.start()
        }
    }

    @Test
    fun `empty check`() {
        val input = "         "
        val inputStream: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)

        assertThatIllegalArgumentException().isThrownBy {
            calculator.start()
        }
    }

    @Test
    fun `invalid operator`() {
        val input = "10 & 2"
        val inputStream: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)

        assertThatIllegalArgumentException().isThrownBy {
            calculator.start()
        }
    }

    @Test
    fun `invalid input1`() {
        val input = "2 + 3 - 1 * 4 / 2  +  2*3"
        val inputStream: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)

        assertThatIllegalArgumentException().isThrownBy {
            calculator.start()
        }
    }

    @Test
    fun `invalid input2`() {
        val input = "2 + 3 - 1 * 4 / 2  +3"
        val inputStream: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)

        assertThatIllegalArgumentException().isThrownBy {
            calculator.start()
        }
    }

    @Test
    fun `invalid input3`() {
        val input = "2 + 3 - 1 * 4 / 2  3"
        val inputStream: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)

        assertThatIllegalArgumentException().isThrownBy {
            calculator.start()
        }
    }
}
