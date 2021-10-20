package step3

object InputView {
    private const val ASK_HOW_MANY_CARS = "자동타 대수는 몇 대인가요?"
    private const val ASK_HOW_MANY_TRY = "시도할 횟수는 몇 회인가요?"

    fun readInputForNumbersOfCars(): Int {
        println(ASK_HOW_MANY_CARS)
        val numberOfCarInput = readLine()
        return numberOfCarInput!!.toInt()
    }

    fun readInputForNumberOfTry(): Int {
        println(ASK_HOW_MANY_TRY)
        val trysInput = readLine()
        return trysInput!!.toInt()
    }
}
