package racing

import racing.domain.Car
import racing.domain.Cars
import racing.domain.RacingGame
import racing.domain.RacingMovingRule
import racing.dto.CarDto
import racing.ui.InputView
import racing.ui.ResultView

object RacingController {
    fun startRacing() {
        val cars = InputView.getCars()
        val movingCount = InputView.getMoveCount()
        val racingGame = RacingGame(cars, RacingMovingRule(movingCount))
        val racing = racingGame.goRacing()
        getRacingResult(racing, cars)
    }

    fun racing(racingGame: RacingGame) : List<CarDto>{
        return racingGame.goRacing()
    }

    private fun getRacingResult(carDtos : List<CarDto>, cars : List<Car>){
        ResultView.showCarRoute(carDtos, cars.size)
        ResultView.printFinalResult(Cars(cars).winner)
    }
}
