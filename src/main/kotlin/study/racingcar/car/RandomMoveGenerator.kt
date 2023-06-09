package study.racingcar.car

class RandomMoveGenerator : MoveGenerator {
    override fun canMove(): Boolean {
        return (0..9).random() >= 4
    }
}
