package study.racingcar.step4

class RacingRun(private val racingCars: List<Racing>) {

    fun nextRun(runnable: Runnable) {
        for (racingCar in racingCars) racingCar.run(runnable.canRun())
    }

    fun racingRecords(): List<RacingRecord> {
        return racingCars.map { racingCar -> RacingRecord(racingCar.getName(), racingCar.getPosition()) }
    }

    fun getWinnerCarNamesAsString(): String {
        val maxPosition = racingCars.maxBy { car -> car.getPosition() }!!.getPosition()
        return racingCars.filter { car -> car.getPosition() == maxPosition }
            .joinToString { car -> car.getName() }
    }

}
