package step3.view

import step3.Car

object ResultView {
    fun output(cars: ArrayList<Car>) {
        print("output for turn\n")
        for (i in 0 until cars.size) {
            print(visualize(cars[i].distance))
        }
    }

    fun visualize(distance: Int): String {
        val block = "-"
        var blocks = ""

        for (i in 0 until distance) {
            blocks += block
        }
        blocks += "\n"
        return blocks
    }
}
