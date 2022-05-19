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
            return RandomIntCarRacingManager(
                RacingCars(inputDto.carNames.map { name -> Car(name) }),
                racingMovementRoleByInt
            )
        }
    }
}
