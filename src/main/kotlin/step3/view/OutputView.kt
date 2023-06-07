package step3.view

import step3.entity.RacingCar

class OutputView(
    private val lineSymbol: String,
) {
    operator fun invoke(racingCars: List<RacingCar>) {
        racingCars.forEach {
            println(lineSymbol.repeat(it.position))
        }
        println("")
    }
}
