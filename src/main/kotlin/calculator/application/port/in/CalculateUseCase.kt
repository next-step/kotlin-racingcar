package calculator.application.port.`in`

interface CalculateUseCase {
    fun compute(calculateCommand: CalculateCommand): String
}
