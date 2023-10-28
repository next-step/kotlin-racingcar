package calculator.application.port.`in`

import calculator.application.service.CalculateCommand

interface CalculateUseCase {
    fun compute(calculateCommand: CalculateCommand): String
}
