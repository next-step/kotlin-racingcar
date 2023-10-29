package study.racingcar

class Car(position: Int = 0) {
    var position = position
        private set

    fun move(randomValue: Int) {
        if (randomValue >= 4) {
            position += 1
        }
    }

    fun displayPosition(): String = "-".repeat(position)
}
