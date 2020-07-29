package racingcar

class Game(private val carNumber: Int) {
    private val carList = createCarList(carNumber)

    private fun createCarList(carNUmber: Int): ArrayList<RacingCar> {
        val returnList = arrayListOf<RacingCar>()
        for (number in 1..carNUmber) {
            returnList.add(RacingCar(number.toString()))
        }
        return returnList
    }

    fun playGameOnce(): ArrayList<RacingCar> {
        carList.forEach {
            it.randomMoving()
        }
        return carList
    }
}
