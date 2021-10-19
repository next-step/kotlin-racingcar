package racingcar.service

class CarMoveForwardRandomValueGetter : CarMoveForwardValueGetter {
    override fun get(): Int {
        return (0..9).random()
    }
}
