package calculator.domain

object CalculatorFactory {

    fun init(): List<Calculator> {
        return listOf(
            AdditionCalculator(),
            SubtractionCalculator(),
            MultiplicationCalculator(),
            DivisionCalculator(),
        )
    }
}
