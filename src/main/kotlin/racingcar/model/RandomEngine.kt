package racingcar.model

object RandomEngine : Engine {
    override fun canMove(): Boolean {
        return (0..9).random() >= 4
    }
}
