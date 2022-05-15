package study.step3

class RacingCar {

    private val carNum = InputView.inputNumberOfCars()
    private val movingNum = InputView.inputNumberOfMoving()

    private val carList = List(carNum){}.map { Car() }

    fun raceStart(){
        for(i in 0..movingNum){
            carList.forEach { it.moveOneStep() }
            carList.forEach { it.printCurrentStep(); println() }
            println()
        }
    }
}
