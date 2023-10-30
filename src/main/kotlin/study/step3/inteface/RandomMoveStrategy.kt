package study.step3.inteface

class RandomMoveStrategy : MoveStrategy {
    companion object {
        private const val MOVE_THRESHOLD = 4
    }

    override fun shouldMove(): Boolean = (0..9).random() >= MOVE_THRESHOLD
}
