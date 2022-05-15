package carracing.util

import carracing.CarListManager
import carracing.CarRacingManager

class CarRacingManagerForTest(carListManager: CarListManager, racingMovementRoleForTest: RacingMovementRoleForTest) :
    CarRacingManager<Int>(carListManager, racingMovementRoleForTest)
