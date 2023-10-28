package study.step3.inteface

class RandomMoveStrategy : MoveStrategy {
    override fun shouldMove(): Boolean = (0..9).random() >= 4
}
