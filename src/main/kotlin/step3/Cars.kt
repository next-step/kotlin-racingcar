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
