package racing

object Racing {
    fun start(carNumber: Int, tryRound: Int): ArrayList<Array<Int>> {
        val racingCars = Array<RacingCar>(carNumber) { RacingCar(tryRound) }

        for (count in 0 until tryRound) {
            for (car in racingCars) {
                car.race()
            }
        }

        return distances(racingCars)
    }

    private fun distances(racingCars: Array<RacingCar>): ArrayList<Array<Int>> {
        val distances = ArrayList<Array<Int>>()

        for (car in racingCars) {
            distances.add(car.getDistances())
        }

        return distances
    }
}
