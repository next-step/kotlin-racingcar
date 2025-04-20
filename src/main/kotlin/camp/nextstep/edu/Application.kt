package camp.nextstep.edu

import camp.nextstep.edu.controller.RacingController
import camp.nextstep.edu.model.RacingGame
import camp.nextstep.edu.view.InputHandler
import camp.nextstep.edu.view.OutputHandler

fun main() {
    val inputHandler = InputHandler
    val racingGame = RacingGame
    val outputHandler = OutputHandler
    val controller = RacingController(inputHandler, racingGame, outputHandler)
    controller.startGame()
}