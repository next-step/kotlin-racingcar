package racingcar

private const val MOVE_VALUE = 4

data class Car(var score: Int = 0) {
    fun move(randomNum: Int) {
        if (randomNum >= MOVE_VALUE) {
            this.score++
        }
    }
}
