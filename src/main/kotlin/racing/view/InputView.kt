package racing.view

import racing.Game

class InputView {

    fun inputRacingGameInfo(): Game {
        println("자동차 대수는 몇 대인가요?")
        val team = readLine()!!.toInt()
        println("시도할 횟수는 몇 회인가요?")
        val round = readLine()!!.toInt()
        return Game(team, round)
    }
}

