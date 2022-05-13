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

    fun runGame(onGameProgress: ((RacingGame) -> Unit)? = null): RacingRecord {
        this.reset()
        val racingRecord = RacingRecord(this.carList)
        repeat(this.stepsToTry) { step ->
            this.carList.forEachIndexed { carIndex, car ->
                car.moveIfItCan()
                racingRecord.writeRecord(carIndex, car)
            }
            this.currentStep = (step + 1)
            onGameProgress?.invoke(this)
        }

        return racingRecord
    }

    private fun reset() {
        this.currentStep = 0
        forEachCar { it.reset() }
    }

    private inline fun forEachCar(block: (Car) -> Unit) {
        this.carList.forEach(block)
    }
}
