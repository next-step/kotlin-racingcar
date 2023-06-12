package race.view

import race.domain.Car

class RaceResult(
    val records: List<List<Car>>,
    val winners: List<Car>
)
