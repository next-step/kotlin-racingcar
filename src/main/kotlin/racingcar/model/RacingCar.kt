package racingcar.model

data class RacingCar(
    private val moveStrategy: MoveStrategy,
    private val movedStatuses: MovingStatuses = MovingStatuses()
) {
    val wentDistance: Int get() = movedStatuses.wentSize

    val nextMoved: RacingCar
        get() = RacingCar(moveStrategy, movedStatuses + moveStrategy.movedStatus)

    override fun toString(): String {
        return "RacingCar(moveStrategy=$moveStrategy, movedStatuses=$movedStatuses)"
    }
}
