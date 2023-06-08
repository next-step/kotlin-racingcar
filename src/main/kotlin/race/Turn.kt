package race

interface TurnInfo {
    val carPositions: List<CarPosition>

    companion object {
        fun getInitialTurn(startInformation: RaceStartInformation): InitialTurn {
            return List(startInformation.numberOfCars) {
                CarPosition.getInitialCarPosition()
            }.let {
                InitialTurn(it)
            }
        }
    }
}

data class Turn(override val carPositions: List<CarPosition>) : TurnInfo

data class InitialTurn(override val carPositions: List<CarPosition>) : TurnInfo
