package racingcar.domain

private const val MOVEMENT_CONDITION_STANDARD = 4

class Car(
    val name: Name,
    val position: Position = Position.ZERO,
) {
    constructor(name: String) : this(Name(name))

    fun moveOrNot(condition: Int): Car {
        if (condition >= MOVEMENT_CONDITION_STANDARD) {
            return Car(
                name = name,
                position = position.next()
            )
        }

        return this
    }
}
