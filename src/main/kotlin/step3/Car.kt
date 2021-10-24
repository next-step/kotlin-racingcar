package step3

data class Car(val distance: Distance = Distance()) {

    init {
        move()
    }

    var forward = DEFAULT_NUMBER_OF_COUNT

    fun move() {
        val currentDrive = distance.calculate()
        when {
            currentDrive > FORWARD_CONDITION -> forward += 1
            else -> forward
        }
    }
}

const val FORWARD_CONDITION = 4
