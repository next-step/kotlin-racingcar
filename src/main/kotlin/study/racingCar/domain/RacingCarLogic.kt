package study.racingCar.domain

class RacingCarLogic {
    fun startRacing(carNum: Int, movingTryNum: Int): List<MutableList<Int>> {
        val cars = (0 until carNum).map { Car() }
        val movedStepsRecords = (0 until movingTryNum).map { (0 until carNum).map { 0 }.toMutableList() }

        for (i in 0 until movingTryNum) {
            for (j in 0 until carNum) {
                cars[j].tryMoveOneStep()
                movedStepsRecords[i][j] = cars[j].movedSteps
            }
        }
        return movedStepsRecords
    }
}
