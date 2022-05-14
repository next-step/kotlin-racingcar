package car_racing

class RandomNumberCarRacingManager(carsList: List<Car> = listOf()) : CarRacingManager(carsList) {
    override fun getMonitoringInformation(): String {
        var result = ""
        for ((index, car) in cars.withIndex()) {
            result += getMonitoringFormatBy(car.distance)
            if (index < cars.size - 1) {
                result += MONITOR_CHARACTER_DIVISION
            }
        }

        return result
    }

    fun tryMoveCar(carIndex: Int, randomInt: Int) {
        validateCarsIndex(carIndex)
        if (isForwardNumber(randomInt)) {
            syncCarDistance(carIndex, cars[carIndex].distance + 1)
        }
    }

    companion object {
        private const val MIN_FORWARD_NUMBER = 4
        private const val MONITOR_CHARACTER_BY_CAR = "-"
        private const val MONITOR_CHARACTER_DIVISION = "\n"

        fun fromInputDto(inputDto: InputDto): RandomNumberCarRacingManager {
            var inputCars = emptyList<Car>()
            repeat(inputDto.carCount) {
                inputCars = inputCars + Car()
            }
            return RandomNumberCarRacingManager(inputCars)
        }

        fun isForwardNumber(randomInt: Int): Boolean {
            return randomInt >= MIN_FORWARD_NUMBER
        }

        fun getMonitoringFormatBy(distance: Int): String {
            var result = MONITOR_CHARACTER_BY_CAR

            for (index: Int in 1..distance) result += MONITOR_CHARACTER_BY_CAR

            return result
        }
    }
}
