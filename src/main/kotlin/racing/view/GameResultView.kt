package racing.view

import racing.Game

class GameResultView(private val game: Game) {

    fun startRacingGame() {
        println("실행 결과")
        for (i in 0 until game.round) {
            game.cars.forEach {
                it.move()
                println(it.getPositionMark())
            }
            println()
        }
    }
}
