package racing

import racing.ui.ResultView
import kotlin.random.Random

class RandomCarRace {
    fun move(cars: Cars, tryNumber: Int, resultView: ResultView){
        for (i in 1..tryNumber) {
            cars.moveAll { Random.nextInt(10 ) }
            resultView.makeResultView(cars)
        }
    }
}