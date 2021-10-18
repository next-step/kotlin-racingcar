package racingcar.domain

class Winners {

    companion object {
        fun findWinners(cars: Cars): Cars {
            return filterWinners(cars, getMaxPosition(cars))
        }

        private fun filterWinners(cars: Cars, maxPosition: Int): Cars {
            val winners = cars.cars.filter { it.isMaxPosition(maxPosition) }
            return Cars(winners)
        }

        private fun getMaxPosition(cars: Cars): Int {
            var maxPosition = 0
            for (car in cars.cars) {
                maxPosition = car.findMaxPosition(maxPosition)
            }
            return maxPosition
        }
    }
}
