package carracing.util

import carracing.domain.RacingCars
import carracing.service.CarRacingManager

class CarRacingManagerForTest(racingCars: RacingCars, racingMovementRoleForTest: RacingMovementRoleForTest) :
    CarRacingManager<Int>(racingCars, racingMovementRoleForTest)
