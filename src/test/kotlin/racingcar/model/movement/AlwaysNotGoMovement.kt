package racingcar.model.movement

internal class AlwaysNotGoMovement : Movement {
    override fun canMoveNow() = false
}
