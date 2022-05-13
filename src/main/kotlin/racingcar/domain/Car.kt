package racingcar.domain

private const val MOVE_BASE_POINT = 4
private const val MOVE_START_POINT = 0
private const val MOVE_END_POINT = 9

open class Car {
    var position = 0
        protected set

    open fun move(movePoint: Int = (0..9).random()) {
        validateMovePoint(movePoint)

        if (movePoint >= MOVE_BASE_POINT) {
            position++
        }
    }

    private fun validateMovePoint(movePoint: Int) {
        if (movePoint > MOVE_END_POINT || movePoint < MOVE_START_POINT) {
            throw IllegalArgumentException("$MOVE_START_POINT ~ $MOVE_END_POINT 사이의 movePoint 만 가능합니다.")
        }
    }
}
