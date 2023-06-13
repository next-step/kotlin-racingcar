package racingcar

fun main() {
    RacingCar().gameStart()
}

class RacingCar {
    fun gameStart() = with(InputView()) {
        race(getNumberOfCars(), getNumberOfRounds())
    }

    private fun race(numberOfCars: Int, numberOfRounds: Int) {
        val score = IntArray(3)

        repeat(numberOfRounds) { _ ->
            repeat(numberOfCars) { car ->
                if (4 <= (1..9).random()) score[car]++
            }
            ResultView.showRaceResult(score)
        }
    }
}
