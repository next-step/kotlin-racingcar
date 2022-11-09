package racing.view

import racing.domain.Game

class GameInputView {

    fun inputRacingGameInfo(): Game {
        println("자동차 대수는 몇 대인가요?")
        val racingCarCount = readLine()!!.toInt()
        require(racingCarCount > 0) { "0보다 큰 값만 입력 가능합니다." }

        println("시도할 횟수는 몇 회인가요?")
        val round = readLine()!!.toInt()
        require(round > 0) { "0보다 큰 값만 입력 가능합니다." }

        return Game(racingCarCount, round)
    }
}
