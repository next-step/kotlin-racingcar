package racingcar.domain

/**
 * 자동차 목록.
 */
data class Cars(val cars: List<Car>) {
    /**
     * 자동차를 이동하고 변경된 자동차 목록을 리턴한다.
     */
    fun move(): Cars = Cars(cars.map { it.moveForward() })

    fun size(): Int {
        return cars.size
    }

    fun findWinners(): Cars {
        return filterWinners(getMaxPosition())
    }

    private fun filterWinners(maxPosition: Int): Cars {
        val winners = cars.filter { it.isMaxPosition(maxPosition) }
        return Cars(winners)
    }

    private fun getMaxPosition(): Int {
        return cars.fold(0) { acc, car ->
            car.findMaxPosition(acc)
        }
    }

    companion object {
        val EMPTY = Cars(emptyList())

        /**
         * 입력받은 대수만큼 자동차 목록을 생성하여 리턴한다.
         */
        fun createCars(carNames: Names): Cars = Cars(carNames.names.map { Car(it) })
    }
}
