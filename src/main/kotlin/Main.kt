fun main() {
    try {

        CarRacingView.showFirstInstruction()
        val numberOfCars = CarRacingView.checkInput(readLine()!!)
        CarRacingView.showSecondInstruction()
        val numberOfTrial = CarRacingView.checkInput(readLine()!!)

        println()
        for (i in 1..numberOfTrial) {
            for (j: Int in 1..numberOfCars) {
                CarRacingView.showMovement(CarRacing.countOfMovement(numberOfCars))
            }
            println()
        }
    } catch (e: Exception) {
        println(e.message)
    }
}
