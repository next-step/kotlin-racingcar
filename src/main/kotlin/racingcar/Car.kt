package racingcar

class Car(private var position: Int = 0) {

    fun position(): Int {
        return position
    }

    fun move(value: Int) {
        if (value >= 4) {
            position++
        }
    }
}
