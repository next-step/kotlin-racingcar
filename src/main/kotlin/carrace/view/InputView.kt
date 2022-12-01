package carrace.view

import carrace.logic.GameRound
import carrace.logic.car.Cars

interface InputView {
    fun inputGameRound(): GameRound
    fun inputCars(): Cars
}
