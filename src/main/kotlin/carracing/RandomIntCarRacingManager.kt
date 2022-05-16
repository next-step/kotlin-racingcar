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
                // Todo Car Name 넣는 것 넣기
                RacingCars(inputDto.carNames.map { name -> Car() }),
                racingMovementRoleByInt
            )
        }
    }
}
