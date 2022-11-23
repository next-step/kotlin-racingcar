package racingcar

class RacingCar private constructor(private val cars: List<Car>, private val tryCount: Int, private val carHistory: HashMap<Car, ArrayList<Int>> = HashMap()) {
    constructor(carCount: Int, tryCount: Int) : this((0 until carCount).map { Car("자동차") }, tryCount)

    private lateinit var moveStrategy: ForwardStrategy

    fun start(moveStrategy: ForwardStrategy): HashMap<Car, ArrayList<Int>> {
        this.moveStrategy = moveStrategy

        for (i in 0 until tryCount) {
            moveCars()
        }
        return carHistory
    }

    private fun moveCars() {
        cars.forEach { car ->
            val carHistoryItem = carHistory[car] ?: ArrayList<Int>().apply {
                carHistory[car] = this
            }

            carHistoryItem.add(car.move(moveStrategy.forward()))
        }
    }
}
