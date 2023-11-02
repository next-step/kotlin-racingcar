package study

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.InputStream

class CalculatorTest {
    companion object {
        val calculator = Calculator(0, 0.0)
    }

    @Test
    fun add() {
        val input = "2 + 3"
        val inputStream: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)

        calculator.start()

        assertThat(calculator.getResult()).isEqualTo(5)
    }

    @Test
    fun sub() {
        val input = "6 - 3"
        val inputStream: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)

        calculator.start()

        assertThat(calculator.getResult()).isEqualTo(3)
    }

    @Test
    fun mul() {
        val input = "4 * 3"
        val inputStream: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)

        calculator.start()

        assertThat(calculator.getResult()).isEqualTo(12)
    }

    @Test
    fun div1() {
        val input = "10 / 2"
        val inputStream: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)

        calculator.start()

        assertThat(calculator.getResult()).isEqualTo(5)
    }

    @Test
    fun div2() {
        val input = "5 / 2"
        val inputStream: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)

        calculator.start()

        assertThat(calculator.getResult()).isEqualTo(2.5)
    }

    @Test
    fun div3() {
        val input = "10 / 0"
        val inputStream: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)

        assertThatIllegalArgumentException().isThrownBy {
            calculator.start()
        }
    }

    @Test
    fun total() {
        val input = "2 + 3 - 1 * 4 / 2"
        val inputStream: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)

        calculator.start()

        assertThat(calculator.getResult()).isEqualTo(8)
    }

    @Test
    fun null_check() {
        val input = ""
        val inputStream: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)

        assertThatIllegalArgumentException().isThrownBy {
            calculator.start()
        }
    }

    @Test
    fun empty_check() {
        val input = "         "
        val inputStream: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)

        assertThatIllegalArgumentException().isThrownBy {
            calculator.start()
        }
    }

    @Test
    fun invalid_operator() {
        val input = "10 & 2"
        val inputStream: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)

        assertThatIllegalArgumentException().isThrownBy {
            calculator.start()
        }
    }

    @Test
    fun invalid_input1() {
        val input = "2 + 3 - 1 * 4 / 2  +  2*3"
        val inputStream: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)

        assertThatIllegalArgumentException().isThrownBy {
            calculator.start()
        }
    }

    @Test
    fun invalid_input2() {
        val input = "2 + 3 - 1 * 4 / 2  +3"
        val inputStream: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)

        assertThatIllegalArgumentException().isThrownBy {
            calculator.start()
        }
    }

    @Test
    fun invalid_input3() {
        val input = "2 + 3 - 1 * 4 / 2  3"
        val inputStream: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)

        assertThatIllegalArgumentException().isThrownBy {
            calculator.start()
        }
    }
}
