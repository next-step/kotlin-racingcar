import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringCalculatorTest {
    class StringCalculator(val input: String) {
        fun calculate(): Int {
            val splitNumberAndSign = split(input)
            var result = splitNumberAndSign[0].toInt()
            for (i in 1 until splitNumberAndSign.size step 2) {
                val sign = splitNumberAndSign[i]
                val targetNumber = splitNumberAndSign[i + 1].toInt()
                result = apply(result, sign, targetNumber)
            }
            return result;
        }

        private fun split(input: String): List<String> {
            return input.split(" ").map { it.trim() }
        }


        private fun apply(result: Int, sign: String, targetNumber: Int): Int{
            if(sign == "+") {
                return result + targetNumber
            }
            if(sign == "-") {
                return result - targetNumber
            }
            if(sign == "*") {
                return result * targetNumber
            }
            if(sign == "/") {
                return result / targetNumber
            }
            throw IllegalArgumentException("The wrong sign was entered. sign : $sign")
        }
    }

    @Test
    fun `string calculator test`() {
        val input = "2 + 3 * 4 / 2"
        val result = StringCalculator(input).calculate()
        assertThat(result).isEqualTo(10)
    }
}
