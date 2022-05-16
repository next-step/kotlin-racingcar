package step3.ui

class InputView {
    fun askCarNames(): String {
        println(ASK_CAR_NAMES_INPUT)
        return readln()
    }

    fun askMoveCount(): Int {
        println(ASK_MOVE_COUNT)
        return readLine()?.toIntOrNull() ?: throw IllegalArgumentException(ONLY_NUMBER_EXCEPTION)
    }

    companion object {
        const val ASK_CAR_NAMES_INPUT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        const val ASK_MOVE_COUNT = "시도할 횟수는 몇 회인가요?"
        const val ONLY_NUMBER_EXCEPTION = "숫자만 입력이 가능합니다.(시도 회수)"
    }
}

