class CarRacingOutputHandler {
    companion object {
        fun display(cars: List<Car>) {
            cars.forEach { car ->
                repeat(car.getMoved()) {
                    print(DASH)
                }
                println()
            }
            println()
        }

        private const val DASH = "-"
    }
}
