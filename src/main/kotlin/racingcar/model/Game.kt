package racingcar.model

class Game() {
    private val cars = Cars()

    fun createCar(numberOfCar: Int) {
        cars.addCar(numberOfCar)
    }

    fun playOneRound() {
        cars.playGameOneRound()
        cars.printOneRoundGameResult()
    }
}
