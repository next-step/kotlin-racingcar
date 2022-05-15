package racingCar

class Race(private val carCount: Int, private val tryCount: Int) {
    val carPositions = mutableListOf<Int>()
    private val cars = mutableListOf<ICar>()

    init {
        for (i: Int in 1..this.carCount) cars.add(Car(Random()))
    }

    fun run() {
        cars.forEach {
            it.moveFor(tryCount)
            carPositions.add(it.position)
        }
    }
}