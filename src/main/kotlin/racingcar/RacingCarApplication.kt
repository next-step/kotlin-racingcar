package racingcar

import racingcar.domain.RacingCarGame

fun main() {
    RacingCarApplication().run()
}

class RacingCarApplication {

    fun run() {
        println("자동차 대수는 몇 대인가요?")
        val carCount: Int = readLine()?.toInt() ?: throw IllegalArgumentException("자동차 대수는 자연수이어야 합니다")
        require(carCount > 0) { throw IllegalArgumentException("자동차 대수는 자연수이어야 합니다") }

        println("시도할 횟수는 몇 회인가요?")
        val roundCount = readLine()?.toInt() ?: throw IllegalArgumentException("라운드 수는 자연수이어야 합니다")
        require(roundCount > 0) { "라운드 수는 자연수이어야 합니다" }

        val racingCarGame = RacingCarGame(carCount, roundCount)
        racingCarGame.start()

        println("실행 결과")
        println(racingCarGame.result())
    }
}
