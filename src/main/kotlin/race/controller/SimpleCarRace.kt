package race.controller

import race.domain.RaceManager
import race.view.Input
import race.view.Output

class SimpleCarRace {
    fun start() {
        val cars = Input().askCarList()
        val moves = Input().askMoveNum()
        val manager = RaceManager(cars, moves)

        repeat(manager.moves) {
            manager.carList.forEach { it.move((0..9).random()) }
            Output().printStatus(manager.carList)
        }

        Output().printResult(manager.findWinners())
    }
}
