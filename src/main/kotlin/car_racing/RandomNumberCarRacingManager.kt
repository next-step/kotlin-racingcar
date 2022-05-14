package car_racing

class RandomNumberCarRacingManager(carsList: List<Car> = listOf()) : CarRacingManager(carsList) {
    fun tryMoveCar(carIndex: Int, randomInt: Int) {
        validateCarsIndex(carIndex)
        syncCarDistance(
            carIndex, cars[carIndex].distance + CarMovementRole.getMoveDistance(randomInt)
        )
    }

    companion object {
        fun fromInputDto(inputDto: InputDto): RandomNumberCarRacingManager {
            var inputCars = emptyList<Car>()
            repeat(inputDto.carCount) {
                inputCars = inputCars + Car()
            }
            return RandomNumberCarRacingManager(inputCars)
        }
    }
}
