package racing.model.move

class MoveAlwaysStrategy : MoveStrategy {
    override fun goNext(): Boolean {
        return true
    }
}
