package racingcar.model

import racingcar.model.movement.DefaultMovement
import racingcar.model.movement.Movement

class RacingGame(
    namesOfCar: List<String>,
    private val stepsToTry: Int,
    movement: Movement = DefaultMovement()
) {

    val carList = namesOfCar.mapIndexed { index, carName ->
        Car(carId = index.toString(), movement = movement, carName = carName)
    }

    var currentStep: Int = 0
        private set

    val isOver: Boolean get() = this.stepsToTry == this.currentStep

    constructor(
        numberOfCar: Int,
        stepsToTry: Int,
        movement: Movement = DefaultMovement()
    ) : this((0 until numberOfCar).map { it.toString() }, stepsToTry, movement)

    fun runGame(onGameProgress: ((RacingGame) -> Unit)? = null): RacingRecord {
        this.reset()
        val racingRecord = RacingRecord(this.carList)
        repeat(this.stepsToTry) { step ->
            goOneStep(racingRecord, step)
            onGameProgress?.invoke(this)
        }

        return racingRecord
    }

    private fun goOneStep(racingRecord: RacingRecord, step: Int) {
        forEachCar { car ->
            car.moveIfItCan()
            racingRecord.writeRecord(car)
        }
        this.currentStep = (step + 1)
    }

    private fun reset() {
        this.currentStep = 0
        forEachCar { it.reset() }
    }

    private inline fun forEachCar(block: (Car) -> Unit) {
        this.carList.forEach(block)
    }
}
