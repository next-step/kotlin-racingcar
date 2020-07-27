package step3.view

import step3.Car

object ResultView {
    fun output(cars: List<Car>) {
        print("output for turn\n")

        for (element in cars) {
            print(visualize(element.distance))
            print("\n")
        }
    }

    fun visualize(distance: Int): String {
        val block = "-"

        return block.repeat(distance)
    }
}
