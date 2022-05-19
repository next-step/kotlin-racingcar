package racingcar

class Car(var position: Int = 0) {

    fun move(condition: Int) {
        if (condition in 4..9) {
            position++
        }
    }

    fun generate(): Int {
        return (0..9).random()
    }
}
