package step4.carRacingWinner.model

object CarGenerator {
    fun generate(carNames: List<String>) = carNames.map { Car(carName = it) }
}
