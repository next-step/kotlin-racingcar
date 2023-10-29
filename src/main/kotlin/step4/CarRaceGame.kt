package step4

class CarRaceGame {

    private val viewer: Viewer = Viewer()
    private val carRace: CarRace

    init {
        viewer.inputCars()
        viewer.inputRound()
        carRace = CarRace(viewer.getCarsName())
    }

    fun startGame() {
        viewer.showResultWords()
        viewer.showCarsPosition(carRace.getCarsPosition())
        repeat(viewer.getRound()) {
            carRace.doRound()
            viewer.showCarsPosition(carRace.getCarsPosition())
        }
        viewer.showWinners(carRace.getWinners())
    }
}
