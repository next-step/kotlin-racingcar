package calculator

class Splitter {
    companion object {
        fun getSymbols(source: String): List<String> =
            source.split(" ")
                .filter {
                    it.toIntOrNull() === null
                }

        fun getNumbers(source: String): List<Int> =
            source.split(" ")
                .filter {
                    it.toIntOrNull() !== null
                }
                .map {
                    it.toInt()
                }
    }
}
