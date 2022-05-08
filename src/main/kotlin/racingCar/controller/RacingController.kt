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

    fun startGame(numberOfCars: Int, numberOfRaces: Int) {
        repeat(numberOfCars) {
            carList.addAll(listOf(Car()))
        }
        repeat(numberOfRaces) {
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

    // 주사위의 숫자는 MINIMUM_SCORE 부터 EXCEEDED_SCORE -1 값까지 나온다.
    // ex MINIMUM_SCORE = 1, EXCEEDED_SCORE = 6 일땐 [1,2,3,4,5]
    private fun rollTheDice(): Int {
        val random = Random()
        return random.nextInt(EXCEEDED_SCORE - MINIMUM_SCORE) + MINIMUM_SCORE
    }

    private fun checkCanRunScore(score: Int): Boolean {
        return score >= SCORE_OF_CAN_GO
    }

    companion object {
        private const val MINIMUM_SCORE = 0
        private const val EXCEEDED_SCORE = 10
        private const val SCORE_OF_CAN_GO = 4
    }
}
