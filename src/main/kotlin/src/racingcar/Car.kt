package src.racingcar

class Car(
    private val name: String,
    private var moveCount: Int = 0
) {

    fun move(carMoveNumber: Int): Int {
       if (CAR_MOVE_CONDITION_NUMBER <= carMoveNumber) moveCount++

       return moveCount
    }

    fun getMoveCount(): Int {
        return moveCount
    }

    fun getCarName(): String {
        return name
    }

    companion object {
        private const val CAR_MOVE_CONDITION_NUMBER = 4
    }
}
