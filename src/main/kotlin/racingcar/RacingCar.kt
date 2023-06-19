package racingcar

fun main() {
    RacingCar.gameStart()
}

const val MOVE_CONDITION_NUMBER = 4

object RacingCar {
    var randomNumber = (1..9).random()

    fun gameStart() = with(InputView) {
        race(getNumberOfCars(), getNumberOfRounds())
            .run { ResultView.showRaceResult(this) }
    }

    private fun race(numberOfCars: Int, numberOfRounds: Int): IntArray {
        val score = IntArray(numberOfCars)

        repeat(numberOfRounds) { _ ->
            repeat(numberOfCars) { car ->
                if (checkMoveAvailable(randomNumber)) score[car]++
            }
        }

        return score
    }

    fun checkMoveAvailable(condition: Int) = condition >= MOVE_CONDITION_NUMBER
}
