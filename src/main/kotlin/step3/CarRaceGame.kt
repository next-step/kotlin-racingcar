package step3

class CarRaceGame {

    private val viewer: Viewer = Viewer()
    private val carRace: CarRace

    init {
        viewer.inputCars()
        viewer.inputRound()
        carRace = CarRace(viewer.getCarsCount())
    }

    fun startGame() {
        viewer.showResultWords()
        viewer.showCarStatus(carRace.getCarsPosition())
        repeat(viewer.getRound()) {
            carRace.doRound()
            viewer.showCarStatus(carRace.getCarsPosition())
        }
    }
}
