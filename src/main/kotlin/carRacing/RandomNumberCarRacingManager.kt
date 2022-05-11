package carRacing

class RandomNumberCarRacingManager() : CarRacingManager {
    override var cars: List<Car> = emptyList()

    constructor(inputDto: InputDto) : this() {
        var inputCars = emptyList<Car>()
        for (index in 1 .. inputDto.carCount) {
            inputCars = inputCars + Car()
        }
        this.cars = inputCars
    }

    override fun addCar(car: Car) {
        cars = cars + car
    }

    override fun syncCarDistance(carsIndex: Int) {
        validateCarsIndex(carsIndex)
        cars[carsIndex].forward()
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

    fun getCarListSize(): Int {
        return cars.size
    }

    fun tryMoveCar(carIndex: Int, randomInt: Int) {
        validateCarsIndex(carIndex)
        if (isForwardNumber(randomInt)) {
            syncCarDistance(carIndex)
        }
    }

    fun validateCarsIndex(carIndex: Int) {
        if (carIndex < 0) {
            throw IllegalArgumentException("음수 값으로 시스템을 실행할수 없습니다")
        }
        if (carIndex > cars.size) {
            throw IllegalArgumentException("존재 하지 않은 번호 입니다")
        }
    }

    companion object {
        private const val MIN_FORWARD = 4
        private const val MONITOR_DIVISION_CHARACTER = "\n"

        fun isForwardNumber(randomInt: Int): Boolean {
            return randomInt >= MIN_FORWARD
        }

        fun getMonitoringFormatBy(distance: Int): String {
            var result = ""

            for (index: Int in 1..distance) result += "-"

            return result
        }
    }
}