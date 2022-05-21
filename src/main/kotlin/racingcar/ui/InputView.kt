package racingcar.ui

class InputView() {
    fun readCarCount(): Int {
        println(CAR_COUNT_TEXT)
        return readln().toInt()
    }

    fun readTryCount(): Int {
        println(TRY_COUNT_TEXT)
        return readln().toInt()
    }

    companion object {
        private const val CAR_COUNT_TEXT = "자동차 대수는 몇 대인가요?"
        private const val TRY_COUNT_TEXT = "시도할 횟수는 몇 회인가요?"
    }
}
