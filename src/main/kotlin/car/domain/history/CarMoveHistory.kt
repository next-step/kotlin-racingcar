package car.domain.history

import car.domain.CarName
import car.domain.Position

data class CarMoveHistory(val carName: CarName, val position: Position)
