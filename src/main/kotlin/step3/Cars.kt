package step3

class Cars constructor(private val numberOfCount: Int = DEFAULT_NUMBER_OF_COUNT, val carList: MutableList<Car> = mutableListOf()) {

    fun makeCar(): List<Car> {
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
