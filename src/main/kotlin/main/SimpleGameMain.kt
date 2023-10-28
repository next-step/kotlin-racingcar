package main

import race.InputView
import race.SimpleCarRace

class SimpleGameMain {
    fun main() {
        val inputs = InputView().printAndRead()
        val race = SimpleCarRace(inputs.first, inputs.second)

        race.start()
    }
}
