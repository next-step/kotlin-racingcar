package racingcar.domain

fun interface CarMovementDecider {
    fun canMove(): Boolean
}
