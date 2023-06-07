class Calculator {

    fun calculate(str : String) : String {
        if(str.isEmpty()) {
            throw IllegalArgumentException()
        }
        val args = str.split(" ")
        val result = cal(args.reversed().toTypedArray())
        println(result)
        return result
    }

    fun cal(str : Array<String>) : String {
        if(str.size == 1) {
            return str[0]
        }

        val oeprator = str[1]
        val num = str[0]

        return when(oeprator) {
            "+" -> {
                plus(cal(str.sliceArray(2 until str.size)), num)
            }
            "-" -> {
                minus(cal(str.sliceArray(2 until str.size)), num)
            }
            "*" -> {
                multiple(cal(str.sliceArray(2 until str.size)), num)
            }
            "/" -> {
                divide(cal(str.sliceArray(2 until str.size)), num)
            }
            else ->
                throw IllegalArgumentException()
        }
    }
    fun plus(num1: String, num2: String) : String {
        if(!isNum(num1) || !isNum(num2)) {
            throw IllegalArgumentException()
        }
        return (num1.toInt() + num2.toInt()).toString()
    }

    fun minus(num1: String, num2: String) : String {
        if(!isNum(num1) || !isNum(num2)) {
            throw IllegalArgumentException()
        }
        return (num1.toInt() - num2.toInt()).toString()
    }

    fun multiple(num1: String, num2: String): String  {
        if(!isNum(num1) || !isNum(num2)) {
            throw IllegalArgumentException()
        }
        return (num1.toInt() * num2.toInt()).toString()
    }

    fun divide(num1: String, num2: String) : String {
        if(!isNum(num1) || !isNum(num2)) {
            throw IllegalArgumentException()
        }
        return (num1.toInt() / num2.toInt()).toString()
    }

    private fun isNum(numberString : String) : Boolean {
        numberString.forEach {
            char ->

            val charConvertedToCode = char.code

            if(charConvertedToCode > 57 || charConvertedToCode < 48) {
                return false
            }
        }
        return true
    }
}