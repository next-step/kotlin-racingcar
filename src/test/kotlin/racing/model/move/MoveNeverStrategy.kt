package racing.model.move

class MoveNeverStrategy : MoveStrategy {
    override fun movable(): Boolean {
        return false
    }
}
