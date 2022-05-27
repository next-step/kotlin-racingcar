package study.racingCar.domain

class RacingCarLogic {
    fun startRacing(carNum: Int, movingTryNum: Int): List<List<Int>> {
        val cars = (0 until carNum).map { Car() }
        val movedStepsRecords = (0 until movingTryNum).map { (0 until carNum).map { 0 }.toMutableList() }


        return (0 until movingTryNum).map {
            cars.map { car ->
                car.moveOneStep()
                car.movedSteps
            }
        }
    }
}
