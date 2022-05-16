package carracing

class RandomIntCarRacingManager(
    cars: Cars,
    racingMovementRoleByInt: RacingMovementRoleByInt
) : CarRacingManager<Int>(cars, racingMovementRoleByInt) {
    companion object {
        fun fromInputDto(
            inputDto: InputDto,
            racingMovementRoleByInt: RacingMovementRoleByInt
        ): RandomIntCarRacingManager {
            var inputCars = emptyList<Car>()
            repeat(inputDto.carCount) {
                inputCars = inputCars + Car()
            }
            return RandomIntCarRacingManager(Cars(inputCars), racingMovementRoleByInt)
        }
    }
}
