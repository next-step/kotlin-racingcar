package step4.carRacingWinner.model

class CarGenerator {
    companion object {
        fun generate(carNames: List<String>) = carNames.map { Car(carName = it) }
    }
}
