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
            val inputCars = List(inputDto.carCount) { Car() }
            return RandomIntCarRacingManager(Cars(inputCars), racingMovementRoleByInt)
        }
    }
}
