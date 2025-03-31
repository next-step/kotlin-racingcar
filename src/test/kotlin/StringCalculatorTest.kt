import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class StringCalculatorTest {
    class StringCalculator(val input: String) {
        fun calculate(): Int {
            val splitExpression = split(input)
            validateExpression(splitExpression)
            var result = splitExpression.first().toInt()
            for (i in 1 until splitExpression.size step 2) {
                validateSign(splitExpression[i])
                val sign = splitExpression[i]
                validateNumber(splitExpression[i + 1])
                val targetNumber = splitExpression[i + 1].toInt()
                result = apply(result, sign, targetNumber)
            }
            return result;
        }

        private fun validateExpression(input: List<String>) {
            if (input.size == 1 && input[0] == "") {
                throw IllegalArgumentException("Input cannot be blank")
            }
            if (input.first().toIntOrNull() == null || input.last().toIntOrNull() == null) {
                throw IllegalArgumentException("Enter a number in the first input or last input")
            }
        }

        private fun split(input: String): List<String> {
            return input.split(" ").map { it.trim() }
        }

        private fun validateSign(input: String) {
            val validSigns = setOf("+", "-", "*", "/")
            if (input !in validSigns) {
                throw IllegalArgumentException("Enter a valid expression")
            }
        }

        private fun validateNumber(input: String) {
            if (input.toIntOrNull() == null) {
                throw IllegalArgumentException("Enter a valid expression")
            }
        }

        private fun apply(result: Int, sign: String, targetNumber: Int): Int {
            return when (Sign.get(sign)) {
                Sign.PLUS -> result + targetNumber
                Sign.MINUS -> result - targetNumber
                Sign.MULTIPLY -> result * targetNumber
                Sign.DIVIDE -> result / targetNumber
            }
        }
    }

    enum class Sign(val value: String) {
        PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/");

        companion object {
            fun get(sign: String): Sign {
                return entries.find { it.value == sign }
                    ?: throw IllegalArgumentException("The wrong sign was entered. sign : $sign")
            }
        }
    }

    @Test
    fun `string calculator test`() {
        val input = "2 + 3 * 4 / 2"
        val result = StringCalculator(input).calculate()
        assertThat(result).isEqualTo(10)
    }

    @Test
    fun `throw exception when input value is blank`() {
        assertThatThrownBy {
            StringCalculator("").calculate()
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Input cannot be blank")
    }

    @Test
    fun `throw exception if the input contains symbols other than arithmetic operators`() {
        assertThatThrownBy {
            StringCalculator("2 + 1 & 3").calculate()
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching("Enter a valid expression")
    }

    @Test
    fun `return the number when the input consists only of number`() {
        val input = "25"
        val result = StringCalculator(input).calculate()
        assertThat(result).isEqualTo(25)
    }

    @Test
    fun `throw exception if the sign is came first`() {
        assertThatThrownBy {
            StringCalculator("+ 1 & 3").calculate()
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Enter a number in the first input or last input")
    }

    @Test
    fun `throw exception if the number is came last`() {
        assertThatThrownBy {
            StringCalculator("1 & 3 +").calculate()
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Enter a number in the first input or last input")
    }

    @Test
    fun `throw exception if there is consecutive sign in expression`() {
        assertThatThrownBy {
            StringCalculator("1 + + 1").calculate()
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Enter a valid expression")
    }
}
