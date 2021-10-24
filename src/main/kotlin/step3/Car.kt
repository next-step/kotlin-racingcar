package step3

data class Car(val distance: Distance = Distance()) {

    init {
        move()
    }

    var forward = 0

    fun move() {
        val currentDrive = distance.calculate()
        when {
            currentDrive > 4 -> forward += 1
            else -> forward
        }
    }
}
