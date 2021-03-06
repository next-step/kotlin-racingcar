package racingcar

class InputView(
    private val carNumberQuestion: String = "자동차 대수는 몇 대인가요?",
    private val trialsQuestion: String = "시도할 횟수는 몇 회인가요?"
) {
    fun receiveValues(): InputValues {
        return InputValues(
            numberOfCars = readInt(carNumberQuestion),
            trials = readInt(trialsQuestion)
        )
    }

    private fun readInt(question: String): Int {
        println(question)
        return readLine()!!.toInt()
    }
}
