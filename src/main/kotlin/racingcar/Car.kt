package racingcar

class Car {
    var progress: Boolean = false

    fun move(condition: Int) {
        if (condition in 4..9) progress = true
    }

    fun generate(): Int {
        return (0..9).random()
    }
}
