package racingcar.model

class Car {
    private var score: Int = 0

    fun move(canMove: Boolean) {
        if (canMove) {
            score++
        }
    }

    fun getScore(): Int {
        return this.score
    }
}
