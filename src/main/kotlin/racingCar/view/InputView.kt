package racingCar.view

class InputView {
    fun inputData() = Pair(inputNumberOfCars(), inputNumberOfTrial())

    private fun inputNumberOfCars(): Int {
        return answer(ANSWER_CAR)
    }

    private fun inputNumberOfTrial(): Int {
        return answer(ANSWER_TRY)
    }

    private fun answer(answer: String): Int {
        println(answer)
        return readLine()!!.toInt()
    }

    companion object {
        private const val ANSWER_CAR = "자동차 대수는 몇 대인가요?"
        private const val ANSWER_TRY = "시도할 횟수는 몇 회인가요?"
    }
}
