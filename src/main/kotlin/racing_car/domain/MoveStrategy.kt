package racing_car.domain

fun interface MoveStrategy {
    fun canMove(): Boolean
}
