package carRacing

abstract class CarRacingManager {
    var cars: List<Car> = emptyList()

    fun addCar(car: Car) {
        cars = cars + car
    }

    protected fun syncCarDistance(carsIndex: Int, distance: Int) {
        validateCarsIndex(carsIndex)
        cars[carsIndex].distance = distance
    }

    fun getCarListSize(): Int {
        return cars.size
    }

    fun getCarDistance(index: Int): Int {
        return cars[index].distance
    }

    fun validateCarsIndex(carIndex: Int) {
        if (carIndex < 0) {
            throw IllegalArgumentException("음수 값으로 시스템을 실행할수 없습니다")
        }
        if (carIndex > cars.size) {
            throw IllegalArgumentException("존재 하지 않은 번호 입니다")
        }
    }

    abstract fun getMonitoringInformation(): String
}