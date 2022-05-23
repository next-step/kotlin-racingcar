package carracing.domain

class RacingCars(val cars: List<Car> = mutableListOf()) {

    fun getMaxDistanceCars(): List<Car> {
        val sortedCars = cars.sortedByDescending { car: Car -> car.distance }
        val maxDistance = sortedCars[0].distance
        return sortedCars.takeWhile { car: Car -> car.distance == maxDistance }
    }

    fun moveCar(carIndex: Int, moveDistance: Int) {
        validateCarsIndex(carIndex)
        cars[carIndex].move(moveDistance)
    }

    fun getCarDistance(carIndex: Int): Int {
        validateCarsIndex(carIndex)
        return cars[carIndex].distance
    }

    fun validateCarsIndex(carIndex: Int) {
        if (carIndex < 0) {
            throw IllegalArgumentException("음수 값으로 시스템을 실행할수 없습니다")
        }
        if (carIndex > cars.size) {
            throw IllegalArgumentException("존재 하지 않은 번호 입니다")
        }
    }
}
