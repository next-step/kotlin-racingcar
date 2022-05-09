package stringCalculator

class Calculator() {
    fun calculate(input: String): Int {
        isValidInput(input)
        val inputList = changeStringToList(input)
        return operate(inputList)
    }

    fun operate(inputList: List<String>): Int{
        var result:Int = inputList[0].toInt()
        for (i in 1 .. inputList.size-1 step 2) {
            val oprend = inputList[i+1].toInt()
            if(inputList[i]=="+"){
                result = add(result, oprend)
            }
            else if(inputList[i]=="-"){
                result = substrate(result, oprend)
            }
            else if(inputList[i]=="*"){
                result = multiple(result, oprend)
            }
            else {
                result = divide(result, oprend)
            }
        }
        return result
    }
    fun changeStringToList (input: String): List<String> {
        return input.split(" ")
    }

    fun getInput() {}

    fun setInput() {}

     fun isValidInput(input: String): Boolean {
        return (
            !isNullOrBlank(input) &&
            !containsNonOperator(input) &&
            startWithNumber(input) &&
            endWithNumber(input) &&
            !containsCharacter(input)
            )
    }

     fun isNullOrBlank(input: String): Boolean {
        return true
    }

     fun containsNonOperator(input: String): Boolean {
        return true
    }

     fun startWithNumber(input: String): Boolean {
        return isNumber(input[0])
    }

     fun endWithNumber(input: String): Boolean {
         return isNumber(input.last())
    }

     fun containsCharacter(input: String): Boolean {
        return true
    }

    fun isNumber ( c: Char ): Boolean {
        return c.code in 0..9
    }
}