package carracing.util

import carracing.CarRacingManager
import carracing.RacingCars

class CarRacingManagerForTest(racingCars: RacingCars, racingMovementRoleForTest: RacingMovementRoleForTest) :
    CarRacingManager<Int>(racingCars, racingMovementRoleForTest)
