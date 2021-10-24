package step3

data class Cars(private val numberOfCount: Int = DEFAULT_NUMBER_OF_COUNT) {

    val carList: List<Car> by lazy { makeCar() }

    private fun makeCar(): List<Car> {
        val carList = mutableListOf<Car>()
        for (i in DEFAULT_NUMBER_OF_COUNT until numberOfCount) {
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

const val DEFAULT_NUMBER_OF_COUNT = 0
