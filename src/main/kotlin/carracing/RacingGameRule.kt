package carracing

import carracing.dto.Car

interface RacingGameRule {
    fun execute(car: List<Car>)
}
