package main

import race.InputView
import race.RaceManager

class SimpleCarRace {
    fun main() {
        val cars = InputView().askCarList()
        val moves = InputView().askMoveNum()

        RaceManager(cars, moves).start()
    }
}
