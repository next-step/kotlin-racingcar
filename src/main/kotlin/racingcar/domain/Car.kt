package racingcar.domain

private const val INITIAL_POSITION = 0

private const val MOVEMENT_CONDITION_STANDARD = 4
private const val NEXT_POSITION = 1

class Car(
    val position: Int = INITIAL_POSITION,
) {
    fun moveOrNot(condition: Int): Car {
        if (condition >= MOVEMENT_CONDITION_STANDARD) {
            return Car(position = position + NEXT_POSITION)
        }

        return this
    }
}
