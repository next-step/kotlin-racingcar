package carracing.util

import carracing.CarRacingManager
import carracing.Cars

class CarRacingManagerForTest(cars: Cars, racingMovementRoleForTest: RacingMovementRoleForTest) :
    CarRacingManager<Int>(cars, racingMovementRoleForTest)
