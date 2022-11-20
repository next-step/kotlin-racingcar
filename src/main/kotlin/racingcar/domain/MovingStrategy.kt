package racingcar.domain

enum class MovingStrategy(
    private val expression: (Int) -> (Int)
) {
    ADVANCE(
        expression = { location -> location + 1 }
    ),
    STOP(
        expression = { location -> location }
    ),
    ;

    fun move(location: Int): Int {
        return expression(location)
    }
}
