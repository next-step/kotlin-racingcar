package study

class StringNumbers(stringsParam: List<String>) {

    private val stringNumbers: MutableList<StringNumber>

    init {
        stringNumbers = stringsParam.map { StringNumber(it) }.toMutableList()
    }

    fun removeFirst(): StringNumber {
        return stringNumbers.removeFirst()
    }

    fun addFirst(element: StringNumber) {
        stringNumbers.add(0, element)
    }

    fun first(): StringNumber {
        return stringNumbers.first()
    }

    fun size(): Int {
        return stringNumbers.size
    }
}
