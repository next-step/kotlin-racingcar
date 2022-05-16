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
            val values: MutableList<Car> = mutableListOf()
            for (i in 0 until numberOfParticipants) {
                values.add(Car())
            }
            return Cars(values)
        }
    }
}
