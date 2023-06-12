package racingcar

data class Car(var score: Int = 0) {
    fun move(strategy: MoveStrategy) {
        if (strategy.move()) {
            this.score++
        }
    }
}
