package racingCar.strategy

interface MoveStrategy {
    fun isMove(): Boolean

    companion object {
        fun getMoveStrategy(): MoveStrategy {
            return MoveRandomStrategy()
        }
    }
}
