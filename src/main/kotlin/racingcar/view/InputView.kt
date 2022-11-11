package racingcar.view

import racingcar.domain.RegisterResult

object InputView {
    fun register(): RegisterResult {
        println("자동차 대수는 몇 대인가요 ?")
        val participant = readln().replace(" ", "")
            .split(",")
            .map {
                require(it.isNotBlank()) { "자동차 이름은 공백이 될 수 없다." }
                require(it.length <= 5) { "자동차 이름은 5자를 초과할 수 없다." }
                it
            }
        println(participant)
        require(participant.isNotEmpty()) { "0대의 차로는 시작할 수 없습니다." }

        println("시도할 횟수는 몇 회인가요?")
        val times = readln().toInt()
        require(times != 0) { "0번의 횟수를 시도할 수 없습니다." }

        return RegisterResult(participant, times)
    }
}
