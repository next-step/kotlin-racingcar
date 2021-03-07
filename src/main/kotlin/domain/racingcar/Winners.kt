package domain.racingcar

class Winners(val names: List<String>) {
    fun getSize(): Int {
        return names.size
    }

    fun getByIndex(index: Int): String {
        return names[index]
    }
}
