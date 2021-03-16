package race.ui

import java.lang.IllegalArgumentException

object InputView {
    fun inputCarNames(): String {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return readLine()
            ?: throw IllegalArgumentException("잘못 입력하였습니다.")
    }

    fun inputRaceCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readLine()
            ?.toIntOrNull()
            ?: throw IllegalArgumentException("횟수를 잘못 입력하였습니다.")
    }
}
