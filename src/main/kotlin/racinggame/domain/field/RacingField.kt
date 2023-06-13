package racinggame.domain.field

import racinggame.domain.car.RacingCar
import racinggame.domain.player.UserUniqueId

class RacingField : RacingFieldMiniMap {

    private val _racingFieldMap = mutableMapOf<UserUniqueId, Field>()
    override val racingFieldMap: Map<UserUniqueId, Field> = _racingFieldMap

    fun ready(racingCars: List<RacingCar>) {
        setUpStartPosition(racingCars)
    }

    fun publishGoSignal() {
        notifyGoSignalToRacingCars()
    }

    fun clear() {
        _racingFieldMap.clear()
    }

    private fun setUpStartPosition(racingCars: List<RacingCar>) {
        racingCars.forEach { racingCar ->
            _racingFieldMap[racingCar.user.id] = Field(
                racingCar = racingCar,
                moveDistance = MoveDistance(FIXED_START_POSITION),
            )
        }
    }

    private fun notifyGoSignalToRacingCars() {
        _racingFieldMap.values
            .map { field -> field.racingCar }
            .map { racingCar -> racingCar to racingCar.tryRun() }
            .forEach { (racingCar, drivableDistance) -> racingCar.move(drivableDistance.value) }
    }

    private fun RacingCar.move(moveDistance: Int) {
        val old = _racingFieldMap[user.id] ?: return
        val new = run {
            val oldMoveDistance = old.moveDistance
            val newMoveDistance = MoveDistance(oldMoveDistance.value + moveDistance)
            old.copy(moveDistance = newMoveDistance)
        }
        _racingFieldMap[user.id] = new
    }

    companion object {
        private const val FIXED_START_POSITION = 0
    }
}
