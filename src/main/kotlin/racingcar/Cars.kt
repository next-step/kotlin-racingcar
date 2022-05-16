package racingcar

@JvmInline
value class Cars(val values: List<Car>) {

    fun move(refuels: List<Int>): Cars {
        val resultCars: MutableList<Car> = mutableListOf()
        for (i in values.indices) {
            resultCars.add(values[i].move(refuels[i]))
        }
        return Cars(resultCars)
    }

    companion object {
        fun initCars(numberOfParticipants: Int): Cars {
            return Cars(List(numberOfParticipants) { Car() })
        }
    }
}
