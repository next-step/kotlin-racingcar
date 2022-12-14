package src.racingcar.domain

open class Car(
    val name: String,
    moveCount: Int = 0
) {

    var moveCount: Int = moveCount
        protected set

    open fun move(carMoveNumber: Int = (MOVE_START_POINT..MOVE_END_POINT).random()): Int {
        if (CAR_MOVE_CONDITION_NUMBER <= carMoveNumber) moveCount++

        return moveCount
    }

    companion object {
        private const val CAR_MOVE_CONDITION_NUMBER = 4
        private const val MOVE_START_POINT = 0
        private const val MOVE_END_POINT = 9
    }
}
