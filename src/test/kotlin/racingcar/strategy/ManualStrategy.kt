package racingcar.strategy

class ManualStrategy(private val condition: Boolean) : MoveStrategy {
    override fun canMove(): Boolean {
        return condition
    }
}
