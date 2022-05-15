package carracing.util

import carracing.CarList
import carracing.CarRacingManager

class CarRacingManagerForTest(carList: CarList, racingMovementRoleForTest: RacingMovementRoleForTest) :
    CarRacingManager<Int>(carList, racingMovementRoleForTest)
