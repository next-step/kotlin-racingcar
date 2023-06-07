package stringcalculator.config

import stringcalculator.StringCalculator
import stringcalculator.extractor.OperandListExtractor
import stringcalculator.extractor.OperatorListExtractor
import stringcalculator.splitter.BlankSplitter

object CalculatorConfig {

    val stringCalculator by lazy {
        StringCalculator(
            splitter = splitter,
            operandListExtractor = operandListExtractor,
            operatorListExtractor = operatorListExtractor
        )
    }

    val splitter by lazy { BlankSplitter }
    val operandListExtractor by lazy { OperandListExtractor }
    val operatorListExtractor by lazy { OperatorListExtractor }
}
