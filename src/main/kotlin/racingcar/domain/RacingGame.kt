package racingcar.domain

class RacingGame {

    fun race(car: Car, randomValue: Int): RacingSituation {
        car.move(randomValue)
        return RacingSituation(Car(car.name, car.position))
    }
}
