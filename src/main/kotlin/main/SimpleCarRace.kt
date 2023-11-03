package main

import race.domain.RaceManager
import race.view.Input

class SimpleCarRace {
    fun main() {
        val cars = Input().askCarList()
        val moves = Input().askMoveNum()

        RaceManager(cars, moves).start()
    }
}
