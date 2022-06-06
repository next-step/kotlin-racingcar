package carracing.util

import carracing.domain.CarRacingManager
import carracing.domain.RacingCars

class CarRacingManagerForTest(racingCars: RacingCars, racingMovementRoleForTest: RacingMovementRoleForTest) :
    CarRacingManager<Int>(racingCars, racingMovementRoleForTest)
