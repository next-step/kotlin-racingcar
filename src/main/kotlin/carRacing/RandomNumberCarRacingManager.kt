package carRacing

class RandomNumberCarRacingManager: CarRacingManager {

    constructor() {}

    constructor(inputDto: InputDto) {
        var inputCars = emptyList<Car>()
        for (index in 1 .. inputDto.carCount) {
            inputCars = inputCars + Car()
        }
        cars = inputCars
    }

     override fun getMonitoringInformation(): String {
        var result = ""
        for ((index, car) in cars.withIndex()) {
            result += getMonitoringFormatBy(car.distance)
            if (index < cars.size - 1) {
                result += MONITOR_DIVISION_CHARACTER
            }
        }

        return result
    }


    fun tryMoveCar(carIndex: Int, randomInt: Int) {
        validateCarsIndex(carIndex)
        if (isForwardNumber(randomInt)) {
            syncCarDistance(carIndex, getCarDistance(carIndex) + 1)
        }
    }

    companion object {
        private const val MIN_FORWARD = 4
        private const val MONITOR_DIVISION_CHARACTER = "\n"

        fun isForwardNumber(randomInt: Int): Boolean {
            return randomInt >= MIN_FORWARD
        }

        fun getMonitoringFormatBy(distance: Int): String {
            var result = "-"

            for (index: Int in 1..distance) result += "-"

            return result
        }
    }
}