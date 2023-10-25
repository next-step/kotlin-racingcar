package calculator.unit.view

import calculator.view.InputView
import calculator.view.InputViewImpl

class InputViewStub(private val formula: String) : InputView {
    override fun inputFormula(): List<String> {
        return formula.split(InputViewImpl.DELIMITER)
    }
}
