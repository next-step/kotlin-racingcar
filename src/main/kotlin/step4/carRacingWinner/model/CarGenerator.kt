package step4.carRacingWinner.model

class CarGenerator {
    companion object {
        fun generate(size: Int) = List<Car>(size) { Car() }
    }
}
