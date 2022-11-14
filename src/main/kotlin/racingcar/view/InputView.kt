package racingcar.view

import racingcar.domain.RegisterResult

object InputView {
    fun register(): RegisterResult {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val participant = readln().split(",")
            .map { it.trim() }

        println("시도할 횟수는 몇 회인가요?")
        val times = readln().toInt()

        return RegisterResult(participant, times)
    }
}
