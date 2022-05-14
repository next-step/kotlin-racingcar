package racing

object Racing {
    fun start(carNumber: Int, tryCount: Int): ArrayList<Array<Int>> {
        val racingCars = Array<RacingCar>(carNumber) { RacingCar(tryCount) }
        for(count in 0 until tryCount) {
            for(car in racingCars) {
                car.tryMove()
            }
        }

        return distances(racingCars)
    }

    private fun distances(racingCars: Array<RacingCar>):ArrayList<Array<Int>> {
        val distances = ArrayList<Array<Int>>()
        for(car in racingCars) {
            distances.add(car.getDistances())
        }

        return distances
    }
}
