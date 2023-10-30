package game.view

import game.domain.History

fun interface UserOutputHandler {
    fun displayHistory(history: History)
}
