package carracing.domain

import carracing.domain.Car

interface RacingGameRule {
    fun execute(cars: List<Car>)
}
