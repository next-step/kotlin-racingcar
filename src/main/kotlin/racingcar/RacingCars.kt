package racingcar

class RacingCars(input: String = "") {
    val cars = mutableListOf<RacingCar>()

    init {
        val inputs = input.split(",")
        (inputs.indices).forEach {
            addCar(RacingCar(inputs[it]))
        }
    }

    fun addCar(car: RacingCar) {
        cars.add(car)
    }

    fun getWinners(): List<RacingCar> {
        val winners = mutableListOf<RacingCar>()
        var winnerPosition = 0
        cars.forEach {
            when {
                winnerPosition < it.position -> {
                    winners.clear()
                    winners.add(it)
                    winnerPosition = it.position
                }

                winnerPosition == it.position -> {
                    winners.add(it)
                }
            }
        }
        return winners
    }
}
