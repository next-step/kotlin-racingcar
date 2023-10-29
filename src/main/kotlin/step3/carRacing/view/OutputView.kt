package step3.carRacing.view

import step3.carRacing.model.Car

interface Print {
    fun print(string:String)
    fun println(string:String)
}

class SystemPrint: Print{
    override fun print(string:String) {
        kotlin.io.print(string)
    }

    override fun println(string:String) {
        kotlin.io.println(string)
    }
}

class OutputView {

    companion object {
        private fun renderCarPosition(car: Car, printer: Print) {
            for (position in 0 until car.curPosition) {
                printer.print("-")
            }
            printer.print("\n")
        }

        fun renderRace(round: Int, cars: List<Car>, printer:Print) {
            printer.println("<-------------- ${round + 1} Round Race 🏎️ -------------->")
            for (car in cars) {
                renderCarPosition(car, printer)
            }
        }
    }


}
