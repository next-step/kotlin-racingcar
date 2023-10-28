package step3

class CarRaceGame {

    private val viewer: Viewer = Viewer()
    private val carRace: CarRace

    init {
        viewer.inputCars()
        viewer.inputRound()
        carRace = CarRace(viewer.getCars())
    }

    fun startGame() {
        viewer.showCarStatus(carRace.getCarStatus())
        repeat(viewer.getRound()) {
            carRace.doRound()
            viewer.showCarStatus(carRace.getCarStatus())
        }
    }
}
