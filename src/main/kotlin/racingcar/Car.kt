package racingcar

class Car(
    val position: Int = 0
) {
    fun move(moveCount: Int): Car {
        if (moveCount in 4..9) {
            return Car(position + 1)
        }
        if (moveCount in 0..3) {
            return Car(position)
        }
        return this
    }
}
