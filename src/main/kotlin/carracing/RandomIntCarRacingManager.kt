package carracing

class RandomIntCarRacingManager(
    carList: CarList,
    randomIntRacingMovementRole: RandomIntRacingMovementRole
) : CarRacingManager<Int>(carList, randomIntRacingMovementRole) {
    companion object {
        fun fromInputDto(
            inputDto: InputDto,
            randomIntRacingMovementRole: RandomIntRacingMovementRole
        ): RandomIntCarRacingManager {
            var inputCars = emptyList<Car>()
            repeat(inputDto.carCount) {
                inputCars = inputCars + Car()
            }
            return RandomIntCarRacingManager(CarList(inputCars), randomIntRacingMovementRole)
        }
    }
}
