package racingcar.model

import racingcar.model.MovingStatus.Companion.wentSize

class RacingCar(private val moveStrategy: MoveStrategy, initialMovedStatuses: Collection<MovingStatus> = emptyList()) {

    private val movedStatuses: Collection<MovingStatus> = initialMovedStatuses.toList()

    val wentDistance: Int get() = movedStatuses.wentSize

    val nextMoved: RacingCar
        get() = RacingCar(moveStrategy, movedStatuses + moveStrategy.movedStatus)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RacingCar

        if (moveStrategy != other.moveStrategy) return false
        return movedStatuses == other.movedStatuses
    }

    override fun hashCode(): Int {
        var result = moveStrategy.hashCode()
        result = 31 * result + movedStatuses.hashCode()
        return result
    }

    override fun toString(): String {
        return "RacingCar(moveStrategy=$moveStrategy, movedStatuses=$movedStatuses)"
    }

    companion object {
        val Collection<RacingCar>.nextMoved: Collection<RacingCar> get() = map { it.nextMoved }
    }
}
