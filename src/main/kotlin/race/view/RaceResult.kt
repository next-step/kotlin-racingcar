package race.view

import race.model.CarRecord

class RaceResult(
    val records: List<List<CarRecord>>,
    val winners: List<CarRecord>
)
