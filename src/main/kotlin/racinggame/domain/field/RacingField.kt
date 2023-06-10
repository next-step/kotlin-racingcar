package racinggame.domain.field

import racinggame.domain.car.RacingCar
import racinggame.domain.car.engine.DrivableDistance
import racinggame.domain.car.factory.RacingCarUniqueKey

class RacingField : RacingFieldMiniMap {

    private val _racingFieldMap = mutableMapOf<RacingCarUniqueKey, Field>()
    override val racingFieldMap: Map<RacingCarUniqueKey, Field> = _racingFieldMap

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
        _racingFieldMap.clear()
    }

    private fun setUpStartPosition(racingCars: List<RacingCar>) {
        racingCars.forEach { racingCar ->
            _racingFieldMap[racingCar.uniqueKey] = Field(
                racingCar = racingCar,
                moveDistance = MoveDistance(
                    startPosition = FIXED_START_POSITION,
                    currentPosition = FIXED_START_POSITION,
                ),
            )
        }
    }

    private fun startObserveRagingCarsWheelSpin() {
        _racingFieldMap.values
            .map { field -> field.racingCar }
            .forEach { racingCar -> racingCar.onWheelsSpinListener = onWheelsSpinListener }
    }

    private fun notifyGoSignalToRacers() {
        _racingFieldMap.values
            .mapNotNull { field -> field.racingCar.racer }
            .forEach { racer -> racer.notifyGo() }
    }

    private fun stopObserveRagingCarsWheelSpin() {
        _racingFieldMap.values
            .map { field -> field.racingCar }
            .forEach { racingCar -> racingCar.onWheelsSpinListener = null }
    }

    private fun RacingCar.move(moveDistance: Int) {
        val old = _racingFieldMap[uniqueKey] ?: return
        val new = run {
            val oldMoveDistance = old.moveDistance
            val currentPosition = oldMoveDistance.currentPosition + moveDistance
            val newMoveDistance = oldMoveDistance.copy(currentPosition = currentPosition)
            old.copy(moveDistance = newMoveDistance)
        }
        _racingFieldMap[uniqueKey] = new
    }

    companion object {
        private const val FIXED_START_POSITION = 0
    }
}
