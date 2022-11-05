package domain

class Operand(val operandList: ArrayList<String?>) {
    init {
        for (operand in operandList) {
            checkOperandValidation(operand)
        }
    }

    private fun checkOperandValidation(input: String?) {
        ValidationChecker().checkNullAndBlankValidation(input)
        ValidationChecker().checkValidNumber(input)
    }
}
