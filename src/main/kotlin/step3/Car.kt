package step3

class Car constructor(val distance: Distance = Distance(), var forward: Int = DEFAULT_NUMBER_OF_COUNT) {

    fun move(currentForward: Int = distance.calculate()): Car {
        when {
            currentForward >= FORWARD_CONDITION -> forward += 1
            else -> forward
        }
        return this
    }
}

private const val FORWARD_CONDITION = 4
