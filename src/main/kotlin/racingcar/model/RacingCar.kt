package racingcar.model

data class RacingCar(
    val name: CarName,
    private val moveStrategy: MoveStrategy,
    private val movedStatuses: MovingStatuses = MovingStatuses()
) {
    val wentDistance: Int get() = movedStatuses.wentSize

    val nextMoved: RacingCar
        get() = RacingCar(name, moveStrategy, movedStatuses + moveStrategy.movedStatus)

    override fun toString(): String {
        return "RacingCar(moveStrategy=$moveStrategy, movedStatuses=$movedStatuses)"
    }
}
