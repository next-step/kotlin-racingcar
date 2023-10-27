package racingCar.domain

import racingCar.domain.strategy.MoveStrategy
import racingCar.domain.strategyImpl.RandomStrategy

class Cars (private val moveStrategy: MoveStrategy = RandomStrategy()){

    fun moveCar(cars: List<Car>){
        for (car in cars) {
            if (moveStrategy.isMove()) car.move()
        }
    }

}