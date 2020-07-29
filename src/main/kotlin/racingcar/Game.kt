package racingcar

class Game(private val carNumber: Int) {
    private val carList = createCarList(carNumber)

    private fun createCarList(carNUmber: Int): List<RacingCar> {
        val returnList = arrayListOf<RacingCar>()
        for (number in 1..carNUmber) {
            returnList.add(RacingCar(number.toString()))
        }
        return returnList
    }

    fun playGameOnce(): List<RacingCar> {
        return carList.onEach {
            it.randomMoving()
        }
    }
}
