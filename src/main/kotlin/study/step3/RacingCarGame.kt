package study.step3

class RacingCarGame {

    fun startRace(racingRequest: Pair<Int, Int>) {
        val cars = prepareRacingCars(racingRequest)

        println("실행결과")

        val attempt = racingRequest.second
        repeat(attempt) {
            cars.forEach { car ->
                val randomValue = randomValue()
                if (randomValue >= 4) {
                    car.move()
                }
                println("-".repeat(car.getState()))
            }
            println()
        }
    }

    private fun prepareRacingCars(
        racingRequest: Pair<Int, Int>
    ): List<Car> = buildList {
        repeat(racingRequest.first) {
            add(Car())
        }
    }

    private fun randomValue() = (0..9).random()
}
