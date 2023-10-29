package step3.carRacing.model

class CarGenerator {
    companion object {
        fun generate(size: Int) = List<Car>(size) { Car() }
    }
}
