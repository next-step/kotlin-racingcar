package racingcar.domain

class RandomMoveStrategy : MoveStrategy {

    override fun isMovable(): Boolean = (0..9).random() > BASE

    companion object {
        const val BASE = 4
    }
}
