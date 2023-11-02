package game.view

import game.domain.GameResult

fun interface UserOutputHandler {
    fun displayResult(gameResult: GameResult)
}
