package racinggame.domain.field

import racinggame.domain.car.RacingCar
import racinggame.domain.car.engine.DrivableDistance
import racinggame.domain.car.factory.RacingCarUniqueKey

class RacingField {

    private val racingFieldMap = mutableMapOf<RacingCarUniqueKey, Field>()

    private val onWheelsSpinListener: ((RacingCar, DrivableDistance) -> Unit) = { racingCar, drivableDistance ->
        racingCar.move(drivableDistance.value)
    }

    fun ready(racingCars: List<RacingCar>) {
        setUpStartPosition(racingCars)
        startObserveRagingCarsWheelSpin()
    }

    fun publishGoSignal() {
        notifyGoSignalToRacers()
    }

    fun clear() {
        stopObserveRagingCarsWheelSpin()
        racingFieldMap.clear()
    }

    private fun setUpStartPosition(racingCars: List<RacingCar>) {
        racingCars.forEach { racingCar ->
            racingFieldMap[racingCar.uniqueKey] = Field(
                racingCar = racingCar,
                moveDistance = MoveDistance(
                    startPosition = FIXED_START_POSITION,
                    currentPosition = FIXED_START_POSITION,
                ),
            )
        }
    }

    private fun startObserveRagingCarsWheelSpin() {
        racingFieldMap.values
            .map { field -> field.racingCar }
            .forEach { racingCar -> racingCar.onWheelsSpinListener = onWheelsSpinListener }
    }

    private fun notifyGoSignalToRacers() {
        racingFieldMap.values
            .mapNotNull { field -> field.racingCar.racer }
            .forEach { racer -> racer.notifyGo() }
    }

    private fun stopObserveRagingCarsWheelSpin() {
        racingFieldMap.values
            .map { field -> field.racingCar }
            .forEach { racingCar -> racingCar.onWheelsSpinListener = null }
    }

    private fun RacingCar.move(moveDistance: Int) {
        val old = racingFieldMap[uniqueKey] ?: return
        val new = run {
            val oldMoveDistance = old.moveDistance
            val currentPosition = oldMoveDistance.currentPosition + moveDistance
            val newMoveDistance = oldMoveDistance.copy(currentPosition = currentPosition)
            old.copy(moveDistance = newMoveDistance)
        }
        racingFieldMap[uniqueKey] = new
    }

    companion object {
        private const val FIXED_START_POSITION = 0
    }
}
