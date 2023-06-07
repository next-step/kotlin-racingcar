package racingcar

class Car(
    var position: Int = 0
) {
    fun move(moveCount: Int): Int {
        if (moveCount in 4..9) {
            return ++position
        }
        if (moveCount in 0..3) {
            return position
        }
        return position
    }
}
