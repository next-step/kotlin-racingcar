package carracing

class RandomIntCarRacingManager(
    carList: CarList,
    racingMovementRoleByInt: RacingMovementRoleByInt
) : CarRacingManager<Int>(carList, racingMovementRoleByInt) {
    companion object {
        fun fromInputDto(
            inputDto: InputDto,
            racingMovementRoleByInt: RacingMovementRoleByInt
        ): RandomIntCarRacingManager {
            var inputCars = emptyList<Car>()
            repeat(inputDto.carCount) {
                inputCars = inputCars + Car()
            }
            return RandomIntCarRacingManager(CarList(inputCars), racingMovementRoleByInt)
        }
    }
}
