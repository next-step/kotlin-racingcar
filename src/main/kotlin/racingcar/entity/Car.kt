package racingcar.entity

class Car(private var moveCount: Int = 0) {
    fun move(distance: Int) {
        if (distance > 4) moveCount += 1
    }

    fun getResult(): String {
        return "-".repeat(moveCount)
    }
}
