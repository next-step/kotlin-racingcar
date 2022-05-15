package carracing

class RandomIntCarRacingManager(
    carListManager: CarListManager,
    randomIntRacingMovementRole: RandomIntRacingMovementRole
) : CarRacingManager<Int>(carListManager, randomIntRacingMovementRole) {
    companion object {
        fun fromInputDto(
            inputDto: InputDto,
            randomIntRacingMovementRole: RandomIntRacingMovementRole
        ): RandomIntCarRacingManager {
            var inputCars = emptyList<Car>()
            repeat(inputDto.carCount) {
                inputCars = inputCars + Car()
            }
            return RandomIntCarRacingManager(CarListManager(inputCars), randomIntRacingMovementRole)
        }
    }
}
