package calculator

object StringCalculator {
    fun calculate(input: String): Double {
        val inputs = input.split(" ")
        val accumulator = Accumulator.startAccumulate(inputs[0])
        for (i in 1 until inputs.size) {
            accumulator.accumulate(inputs[i])
        }
        return accumulator.getResult()
    }
}
