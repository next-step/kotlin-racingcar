package car_racing

class RandomNumberCarRacingManager(carsList: List<Car> = listOf()) : CarRacingManager(carsList) {
    fun tryMoveCar(carIndex: Int, randomInt: Int) {
        validateCarsIndex(carIndex)
        if (isForwardNumber(randomInt)) {
            syncCarDistance(carIndex, cars[carIndex].distance + 1)
        }
    }

    companion object {
        private const val MIN_FORWARD_NUMBER = 4

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
    }
}
