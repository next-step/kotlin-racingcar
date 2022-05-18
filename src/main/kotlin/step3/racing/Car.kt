package step3.racing

private const val MOVING_CONDITION = 4

class Car(val name: String) {
    var distance: Int = 0
        private set

    fun run(input: Int): Car {
        if (input >= MOVING_CONDITION) distance += 1
        return this
    }
}
