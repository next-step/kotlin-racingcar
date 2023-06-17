package racingcar

class RacingCars(input: String) {
    val cars = mutableListOf<RacingCar>()

    init {
        val inputs = input.split(",")
        (inputs.indices).forEach {
            cars.add(RacingCar(inputs[it]))
        }
    }
}
