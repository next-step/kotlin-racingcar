package camp.nextstep.edu.step.racing.strategy

class RandomMoveStrategy : CarMoveStrategy {

    override fun isMovable(): Boolean {
        return (0..9).random() >= 4
    }

}
