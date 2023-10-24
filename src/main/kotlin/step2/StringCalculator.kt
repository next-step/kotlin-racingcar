package step2

class StringCalculator {
    companion object {
        fun calculate(input: String): Int {
            input.split(" ").let {
                return it[0].toInt() + it[2].toInt()
            }
        }
    }
}
