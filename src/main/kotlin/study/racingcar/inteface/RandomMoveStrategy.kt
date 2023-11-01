package study.racingcar.inteface

class RandomMoveStrategy : MoveStrategy {
    override fun shouldMove(): Boolean = (0..9).random() >= MOVE_THRESHOLD

    companion object {
        private const val MOVE_THRESHOLD = 4
    }
}
