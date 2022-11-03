package step2.interfaces.parser

import step2.domain.calculator.model.InputOperationCommand

interface ParsingProcessor {

    fun proceed(string: String): List<InputOperationCommand>
}
