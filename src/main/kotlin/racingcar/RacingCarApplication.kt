package racingcar

import racingcar.domain.CarCount
import racingcar.domain.RacingCarGame
import racingcar.domain.RoundCount

fun main() {
    RacingCarApplication().run()
}

class RacingCarApplication {

    fun run() {
        println("자동차 대수는 몇 대인가요?")
        val carCount = CarCount(readLine() ?: "")

        println("시도할 횟수는 몇 회인가요?")
        val roundCount = RoundCount(readLine() ?: "")

        val racingCarGame = RacingCarGame(carCount, roundCount)
        racingCarGame.start()

        println("실행 결과")
        println(racingCarGame.result())
    }
}
