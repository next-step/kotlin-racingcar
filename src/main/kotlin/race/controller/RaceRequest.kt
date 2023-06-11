package race.controller

import race.Car

class RaceRequest(
    val numberOfTry: Int,
    val cars: List<Car>
)
