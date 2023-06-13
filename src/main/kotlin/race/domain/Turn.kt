package race.domain

interface TurnInfo {
    val cars: List<Car>
}

data class Turn(override val cars: List<Car>) : TurnInfo

class InitialTurn(startInformation: RaceStartInformation) : TurnInfo {
    override val cars: List<Car> = startInformation.nameOfCars
        .map {
            Car.getInitialCar(it)
        }
}
