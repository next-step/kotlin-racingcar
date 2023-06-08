package race

data class Turn(val carPositions: List<CarPosition>) {
    companion object {
        fun getInitialTurn(startInformation: RaceStartInformation): Turn {
            return List(startInformation.numberOfCars) {
                CarPosition.getInitialCarPosition()
            }.let {
                Turn(it)
            }
        }
    }
}
