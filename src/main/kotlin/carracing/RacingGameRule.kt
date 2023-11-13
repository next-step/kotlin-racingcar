package carracing

import carracing.dto.Car

interface RacingGameRule {
    fun execute(cars: List<Car>)
}
