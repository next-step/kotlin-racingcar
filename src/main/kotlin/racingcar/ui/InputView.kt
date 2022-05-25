package racingcar.ui

class InputView() {
    fun readCarNames(): String {
        println(CAR_NAMES_TEXT)
        return readln()
    }

    fun readTryCount(): Int {
        println(TRY_COUNT_TEXT)
        return readln().toInt()
    }

    companion object {
        private const val CAR_NAMES_TEXT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        private const val TRY_COUNT_TEXT = "시도할 횟수는 몇 회인가요?"
    }
}
