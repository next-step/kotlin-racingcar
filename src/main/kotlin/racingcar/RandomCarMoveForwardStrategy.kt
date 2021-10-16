package racingcar

class RandomCarMoveForwardStrategy : CarMoveForwardStrategy {
    override fun canMoveForward(): Boolean {
        return (0..9).random() >= 4
    }
}
