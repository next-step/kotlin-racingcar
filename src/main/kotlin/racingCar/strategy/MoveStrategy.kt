package racingCar.strategy

interface MoveStrategy {
    fun moveCar(): Int

    companion object {
        fun getMoveStrategy(): MoveStrategy {
            return MoveRandomStrategy()
        }
    }
}
