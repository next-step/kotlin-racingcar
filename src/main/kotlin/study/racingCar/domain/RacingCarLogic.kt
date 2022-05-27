package study.racingCar.domain

class RacingCarLogic {
    fun startRacing(carNames: List<String>, movingTryNum: Int): List<List<Int>> {
        val cars = (carNames.indices).map { Car(carNames[it]) }

        return (0 until movingTryNum).map {
            cars.map { car ->
                car.moveOneStep()
                car.movedSteps
            }
        }
    }
}
