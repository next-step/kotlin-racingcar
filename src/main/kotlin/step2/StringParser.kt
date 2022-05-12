package step2

class StringParser(val delimiter: String = " ") {
    fun parse(s: String?): List<String> {
        return s!!.split(delimiter).toList()
    }
}