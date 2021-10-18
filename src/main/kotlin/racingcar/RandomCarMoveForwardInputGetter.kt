package racingcar

class RandomCarMoveForwardInputGetter : CarMoveForwardValueGetter {
    override fun get(): Int {
        return (0..9).random()
    }
}
