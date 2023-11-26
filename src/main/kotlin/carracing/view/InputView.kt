package carracing.view

import carracing.domain.CarRacingValidator

class InputView(
    private val carRacingValidator: CarRacingValidator,
) {
    fun inputCount(inputType: InputType): Int {
        println(inputType.question)
        return readln().toInt()
    }

    fun inputNames(inputType: InputType): List<String> {
        println(inputType.question)
        return readln().split(",").map {
            carRacingValidator.validateCarName(it)
            it
        }
    }
}
