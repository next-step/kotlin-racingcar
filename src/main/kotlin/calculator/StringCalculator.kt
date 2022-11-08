package calculator

object StringCalculator {

    fun calculate(input: String): Long {

        val split: List<String> = input.split(" ")

        var result = split[0].toLong()
        for (i in 1 until split.size step 2) {
            result = when (split[i]) {
                "+" -> result + split[i + 1].toLong()
                "-" -> result - split[i + 1].toLong()
                "*" -> result * split[i + 1].toLong()
                "/" -> result / split[i + 1].toLong()
                else -> throw IllegalArgumentException("올바른 사칙연산 기호가 아닙니다.")
            }
        }

        return result
    }
}
