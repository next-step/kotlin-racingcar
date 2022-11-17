package src.racingcar

class Car(private var moveCount: Int = 0) {

    fun move(): Int {
       if (CAR_MOVE_CONDITION_NUMBER <= getCarMoveRandomValue()) moveCount++

       return moveCount
    }

    companion object {
        private const val CAR_MOVE_CONDITION_NUMBER = 4
    }
}
