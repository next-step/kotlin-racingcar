package racing.view

object GameInputView {

    fun inputRacingCarCount(): Int {
        println("자동차 대수는 몇 대인가요?")
        val racingCarCount = readLine()!!.toInt()
        require(racingCarCount > 0) { "0보다 큰 값만 입력 가능합니다." }
        return racingCarCount
    }

    fun inputRacingRound(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val round = readLine()!!.toInt()
        require(round > 0) { "0보다 큰 값만 입력 가능합니다." }
        return round
    }
}
