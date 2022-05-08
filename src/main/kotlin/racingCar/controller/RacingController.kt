package racingCar.controller

import racingCar.model.Car
import racingCar.model.RaceResult
import java.util.Random

/**
 * 레이싱을 시작하고, 계산하는 클래스
 * Created by Jaesungchi on 2022.05.07..
 */
class RacingController {
    private val carList: MutableList<Car> = mutableListOf()
    val raceResults: MutableList<RaceResult> = mutableListOf()

    fun startGame(countOfCar: Int, countOfRace: Int) {
        repeat(countOfCar) {
            carList.addAll(listOf(Car()))
        }
        repeat(countOfRace) {
            processGame()
            raceResults.add(RaceResult(carList))
        }
    }

    private fun processGame() {
        carList.forEach { car ->
            if (checkCanRunScore(rollTheDice())) {
                car.position++
            }
        }
    }

    private fun rollTheDice(): Int {
        val random = Random()
        return random.nextInt(DICE_SIZE)
    }

    private fun checkCanRunScore(score: Int): Boolean {
        return score >= SCORE_OF_CAN_GO
    }

    companion object {
        private const val DICE_SIZE = 10
        private const val SCORE_OF_CAN_GO = 4
    }
}
