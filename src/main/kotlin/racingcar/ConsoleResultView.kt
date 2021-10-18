package racingcar

class ConsoleResultView : ResultView {
    companion object {
        private const val CAR_POSITION_CHARACTER = "-"
        private const val RESULT_TITLE = "실행 결과"
    }

    override fun showTitle() {
        println("\n" + RESULT_TITLE)
    }

    override fun showStatuses(cars: Cars) {
        cars.getCars()
            .forEach { car ->
                print("%02d: ".format(car.number))
                for (index in (1..car.position)) {
                    print(CAR_POSITION_CHARACTER)
                }
                println()
            }
        println()
    }
}
