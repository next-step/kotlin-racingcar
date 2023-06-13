package racingcar

class Car(score: Int = 0) {

    var score: Int = score
        private set

    fun move(strategy: MoveStrategy) {
        if (strategy.move()) {
            this.score++
        }
    }
}
