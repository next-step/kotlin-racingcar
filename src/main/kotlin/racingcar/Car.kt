package racingcar

class Car(
    val position: Int = 0
) {
    fun move(moveCount: Int): Car {
        if (moveCount in 4..9) {
            return Car(position + 1)
        }
        return Car(position)
    }
}
