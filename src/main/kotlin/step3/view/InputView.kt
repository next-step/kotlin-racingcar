package step3.view

class InputView {
    companion object {
        private const val CAR_NUMBER_INPUT_MESSAGE = "자동차 대수는 몇 대인가요?"
        private const val PLAY_TIME_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?"
        private const val ERROR = "[ERROR] "

        fun setInputData(): Pair<Int, Int> {
            return try {
                val carNumber = inputCarNumber()
                val playTime = inputPlayTime()
                Pair(carNumber, playTime)
            } catch (e: Exception) {
                println(ERROR + e.message)
                setInputData()
            }
        }

        private fun inputCarNumber(): Int {
            println(CAR_NUMBER_INPUT_MESSAGE)
            return readLine()!!.toInt()
        }

        private fun inputPlayTime(): Int {
            println(PLAY_TIME_INPUT_MESSAGE)
            return readLine()!!.toInt()
        }
    }
}
