package step3.ui

object InputInterface {
    fun input(): InputValue {
        val numberOfCars = printAndReadInt("자동차 대수는 몇 대 인가요?")
        val numberOfTrials = printAndReadInt("시도할 회수는 몇 회 인가요?")

        return InputValue(numberOfCars, numberOfTrials)
    }

    private fun printAndReadInt(message: String): Int {
        println(message)
        return readlnOrNull()?.toInt() ?: 0
    }
}

class InputValue(
    val numberOfCars: Int,
    val numberOfTrials: Int,
)
