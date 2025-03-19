
class StringCalculatorTest {
    class StringCalculator(val input: String) {
        fun calculate(): Int {
            val splitNumberAndSign = split(input)
            return 0;
        }

        private fun split(input: String): List<String> {
            return input.split(" ").map { it.trim() }
        }
    }
}
