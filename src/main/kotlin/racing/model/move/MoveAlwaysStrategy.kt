package racing.model.move

class MoveAlwaysStrategy : MoveStrategy {
    override fun movable(): Boolean {
        return true
    }
}
