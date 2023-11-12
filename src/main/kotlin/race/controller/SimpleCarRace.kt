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
            manager.move()
            Output().printStatus(manager.cars)
        }

        Output().printResult(manager.cars.findWinners())
    }
}
