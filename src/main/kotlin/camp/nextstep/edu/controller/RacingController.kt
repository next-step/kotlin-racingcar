package camp.nextstep.edu.controller
import camp.nextstep.edu.model.Car
import camp.nextstep.edu.model.RacingGame
import camp.nextstep.edu.view.InputHandler
import camp.nextstep.edu.view.OutputHandler

object RacingController {

    fun run() {
        val carNames = InputHandler.readCarNames()
        val cars = carNames.map(::Car)
        val numberOfMoves = InputHandler.getNumberOfMoves()

        println("\n경주 시작!")
        repeat(numberOfMoves) { round ->
            println("\n${round + 1} 번째 이동")
            RacingGame.playRound(cars)
            val positions = RacingGame.getCarPositions(cars)
            OutputHandler.displayRoundResult(positions)
        }

        val winners = RacingGame.findWinners(cars)
        OutputHandler.displayWinners(winners)
    }

}