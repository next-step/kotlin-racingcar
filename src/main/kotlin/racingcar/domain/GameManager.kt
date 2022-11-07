package racingcar.domain

import racingcar.etc.ResultView

class GameManager(carNames: CarNames, private val numberOfRaces: Int) {

    private val cars: Cars = Cars(carNames)

    fun racing() {
        println("\n실행 결과")
        for (race in 1..numberOfRaces) {
            cars.racing()
            ResultView.racing(cars.racingResult())
        }
    }
}
