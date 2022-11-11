package racingcar.view

import racingcar.domain.RegisterResult

object InputView {
    fun register(): RegisterResult {
        println("자동차 대수는 몇 대인가요 ?")
        val participant = readLine()!!.toInt()
        require(participant != 0) { "0대의 차로는 시작할 수 없습니다." }

        println("시도할 횟수는 몇 회인가요?")
        val times = readLine()!!.toInt()
        require(times != 0) { "0번의 횟수를 시도할 수 없습니다." }

        return RegisterResult(participant, times)
    }
}
