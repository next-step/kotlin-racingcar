package step3

data class Cars(private val numberOfCount: Int = 0) {

    val carList: List<Car> by lazy { makeCar() }

    private fun makeCar(): List<Car> {
        val carList = mutableListOf<Car>()
        for (i in 0 until numberOfCount) {
            carList.add(Car(Distance()))
        }
        return carList
    }

    fun moveCars() {
        carList.forEach {
            it.move()
        }
    }
}

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

data class Distance(val default: Int = 0) {
    fun calculate() = (0..9).random()
}
