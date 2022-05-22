package step3.racing.domain

private const val MOVING_CONDITION = 4
private const val DEFAULT_DISTANCE = 0

class Car(val name: String, var distance: Int = DEFAULT_DISTANCE) {
    fun run(input: Int): Car {
        if (input >= MOVING_CONDITION) distance += 1
        return this
    }
}
