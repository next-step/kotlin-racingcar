package step3

class Car constructor(val distance: Distance = Distance()) {

    init {
        move()
    }

    var forward = DEFAULT_NUMBER_OF_COUNT

    fun move() {
        val currentDrive = Distance().calculate()
        when {
            currentDrive > FORWARD_CONDITION -> forward += 1
            else -> forward
        }
    }
}

private const val FORWARD_CONDITION = 4
