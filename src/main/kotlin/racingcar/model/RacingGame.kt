package racingcar.model

import racingcar.model.movement.DefaultMovement
import racingcar.model.movement.Movement

class RacingGame(
    numberOfCar: Int,
    private val stepsToTry: Int,
    movement: Movement = DefaultMovement()
) {

    val carList = (0 until numberOfCar).map { Car(movement = movement) }
    var currentStep: Int = 0
        private set
    val isOver: Boolean get() = this.stepsToTry == this.currentStep

    fun runGame(onGameProgress: ((RacingGame) -> Unit)? = null): RacingGame {
        this.reset()
        repeat(this.stepsToTry) { step ->
            this.forEachCar { it.moveIfItCan() }
            this.currentStep = (step + 1)
            onGameProgress?.invoke(this)
        }

        return this
    }

    private fun reset() {
        this.currentStep = 0
        forEachCar { it.reset() }
    }

    private inline fun forEachCar(block: (Car) -> Unit) {
        this.carList.forEach(block)
    }
}
