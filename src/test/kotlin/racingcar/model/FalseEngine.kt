package racingcar.model

object FalseEngine : Engine{
    override fun canMove(): Boolean {
        return false
    }
}
