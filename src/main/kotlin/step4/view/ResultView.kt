package step4.view

import step4.Car

object ResultView {
    private const val CAR_NAME_SEPARATOR = " : "
    private const val ONE_BLOCK = "-"
    private const val LINE_BREAK = "\n"

    fun output(numberOfTrials: Int, cars: List<Car>) {
        print("trial$CAR_NAME_SEPARATOR$numberOfTrials$LINE_BREAK")

        for (element in cars) {
            print("${element.name}$CAR_NAME_SEPARATOR" + visualize(numberOfTrials, element.raceResult) + LINE_BREAK)
        }
    }

    fun visualize(numberOfTrials: Int, raceResult: ArrayList<Int>): String {
        var distance = 0

        for (i in 0 until numberOfTrials) {
            distance += raceResult[i]
        }
        return ONE_BLOCK.repeat(distance)
    }
}
