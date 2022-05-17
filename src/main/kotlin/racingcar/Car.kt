package racingcar

class Car {
    var progress: Boolean = false
    var position: Int = 0

    init {
        position++
    }

    fun move(condition: Int) {
        if (condition in 4..9) {
            progress = true
            position++
        }
    }

    fun generate(): Int {
        return (0..9).random()
    }
}
