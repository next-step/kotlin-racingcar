package racingcar

@JvmInline
value class Cars(val values: List<Car>) {

    fun move(refuels: List<Int>): Cars {
        val carsAndRefuels = values zip refuels
        return Cars(carsAndRefuels.map { it.first.move(it.second) })
    }

    companion object {
        fun initCars(numberOfParticipants: Int): Cars {
            return Cars(List(numberOfParticipants) { Car() })
        }
    }
}
