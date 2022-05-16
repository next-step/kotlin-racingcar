package carracing

class RandomIntCarRacingManager(
    racingCars: RacingCars,
    racingMovementRoleByInt: RacingMovementRoleByInt
) : CarRacingManager<Int>(racingCars, racingMovementRoleByInt) {
    companion object {
        fun fromInputDto(
            inputDto: InputDto,
            racingMovementRoleByInt: RacingMovementRoleByInt
        ): RandomIntCarRacingManager {
            val inputCars = List(inputDto.carCount) { Car() }
            return RandomIntCarRacingManager(RacingCars(inputCars), racingMovementRoleByInt)
        }
    }
}
