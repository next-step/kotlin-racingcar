package racing.model.move

class MoveNeverStrategy : MoveStrategy {
    override fun goNext(): Boolean {
        return false
    }
}
