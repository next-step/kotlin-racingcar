package car_racing

class RandomNumberCarRacingManager(carListManager: CarListManager) : CarRacingManager(carListManager) {
    fun tryMoveCar(carIndex: Int, randomInt: Int) {
        val nowDistance = carListManager.getCarDistance(carIndex) + CarMovementRole.getMoveDistance(randomInt)
        syncCarDistance(carIndex, nowDistance)
    }

    fun getCarSize(): Int {
        return carListManager.cars.size
    }

    companion object {
        fun fromInputDto(inputDto: InputDto): RandomNumberCarRacingManager {
            var inputCars = emptyList<Car>()
            repeat(inputDto.carCount) {
                inputCars = inputCars + Car()
            }
            return RandomNumberCarRacingManager(CarListManager(inputCars))
        }
    }
}
