package calculator.application.parser

import calculator.domain.calculator.model.InputOperationCommand

interface ParsingProcessor {

    fun proceed(string: String): List<InputOperationCommand>
}
