package racingcar.view

import racingcar.domain.TrialCount

private const val CAR_NAME_SPLITTER = ","

class ConsoleInput : InputView {
    override fun askCountOfTrial(): TrialCount {
        return try {
            println("시도할 횟수는 몇 회인가요?")
            TrialCount(readln().toInt())
        } catch (e: IllegalArgumentException) {
            println(e.message)
            askCountOfTrial()
        }
    }

    override fun askCarNames(): List<String> {
        return try {
            println("자동차 이름을 입력해주세요")
            readln().split(CAR_NAME_SPLITTER).map { it.trim() }
        } catch (e: IllegalArgumentException) {
            println(e.message)
            askCarNames()
        }
    }
}
