package step3.carRacing.view

import step3.carRacing.Car

class OutputView {

    companion object {
        private fun renderCarPosition(car: Car) {
            for (position in 0 until car.curPosition) {
                print('-')
            }
            print("\n")
        }

        fun renderRace(round: Int, cars: List<Car>) {
            println("<-------------- ${round + 1} Round Race 🏎️ -------------->")
            for (car in cars) {
                renderCarPosition(car)
            }
        }
    }


}
