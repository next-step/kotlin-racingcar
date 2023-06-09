package race

interface TurnInfo {
    val carPositions: List<CarPosition>
}

data class Turn(override val carPositions: List<CarPosition>) : TurnInfo

class InitialTurn(startInformation: RaceStartInformation) : TurnInfo {
    override val carPositions: List<CarPosition> = List(startInformation.nameOfCars.size) {
        CarPosition.getInitialCarPosition()
    }
}
