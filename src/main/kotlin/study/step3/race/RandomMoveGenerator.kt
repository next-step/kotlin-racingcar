package study.step3.race

class RandomMoveGenerator : MoveGenerator {
    override fun canMove(): Boolean {
        return (0..9).random() >= 4
    }
}
