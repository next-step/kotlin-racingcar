package racingcar

class RacingCar private constructor(private val cars: ArrayList<Car> = ArrayList(), private val tryCount: Int, private val carHistory: LinkedHashMap<Car, ArrayList<Int>> = LinkedHashMap()) {
    constructor(carNames: String, tryCount: Int) : this(ArrayList(), tryCount) {
        val spitNames = carNames.split(",")
        spitNames.forEach { name ->
            cars.add(Car(name.trim()))
        }
    }

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
