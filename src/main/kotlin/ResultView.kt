class ResultView(private val carManager: CarManager) {
    init {
        status()
    }

    private fun status() {
        println("실행 결과")
        printCarsStep()
    }

    private fun printCarsStep() {
        for (i in 0 until carManager.tryCount) {
            println((i + 1).toString() + " 시도")
            for (car in carManager.carList) {
                printStep(car, i)
            }
        }
    }

    private fun printStep(car: Car, tryCount: Int) {
        repeat(car.stepList[tryCount]) {
            print(STEP_MARKER)
        }
        println()
    }

    companion object {
        val STEP_MARKER = "-"
    }
}
