package step3.car

data class Car(var moveCount: Int) {
    fun canMoveForward(number: Int) = number >= MOVE_CONDITION

    companion object {
        const val MOVE_CONDITION = 4
    }
}
