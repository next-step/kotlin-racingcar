package racingcar

import racingcar.domain.Car
import racingcar.domain.Race

class RacingGame {

    fun play(){
        val cars = Car().make()
        val race = Race().make()
        race.printResultTitle()
        race.run(cars)
    }

}
