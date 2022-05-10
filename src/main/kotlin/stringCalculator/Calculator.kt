package stringCalculator

class Calculator() {

    /**
     *  Getter/ Setter: 모든 property에는 기본적으로 getter/setter 설정이 있다.
        var input: String = ""
            get() {
                return field
            }
            set(value){
                field = value
            }
     */

    // default: public final
    var input: String = ""

    fun calculate(): Int {
        isValidInput(input)
        val inputList = changeStringToList(input)
        return operate(inputList)
    }

    private fun operate(inputList: List<String>): Int {
        var result: Int = inputList[0].toInt()
        for (i in 1..inputList.size - 1 step 2) {
            val oprend = inputList[i + 1].toInt()
            if (inputList[i] == "+") {
                result = add(result, oprend)
            } else if (inputList[i] == "-") {
                result = substrate(result, oprend)
            } else if (inputList[i] == "*") {
                result = multiple(result, oprend)
            } else {
                result = divide(result, oprend)
            }
        }
        return result
    }

    private fun changeStringToList(input: String): List<String> {
        return input.split(" ")
    }

    private fun isValidInput(input: String): Boolean {
        return (
            !isNullOrBlank(input) &&
                !containsNonOperator(input) &&
                startWithNumber(input) &&
                endWithNumber(input) &&
                !containsCharacter(input)
            )
    }

    private fun isNullOrBlank(input: String): Boolean {
        return true
    }

    private fun containsNonOperator(input: String): Boolean {
        return true
    }

    private fun startWithNumber(input: String): Boolean {
        return isNumber(input[0])
    }

    private fun endWithNumber(input: String): Boolean {
        return isNumber(input.last())
    }

    private fun containsCharacter(input: String): Boolean {
        return true
    }

    private fun isNumber(c: Char): Boolean {
        return c.code in 0..9
    }
}