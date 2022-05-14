package car_racing

abstract class CarRacingManager(var cars: List<Car> = mutableListOf()) {

    protected fun syncCarDistance(carsIndex: Int, distance: Int) {
        validateCarsIndex(carsIndex)
        cars[carsIndex].distance = distance
    }

    fun getCarSize(): Int {
        return cars.size
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
