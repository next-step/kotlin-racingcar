package car.view.input

class CarNamesInput(names: String?) {
    private val names: String

    init {
        require(!names.isNullOrBlank()) { "이름은 공백이면 안됩니다." }

        this.names = names
    }

    fun splitNameBySplitter(): Array<String> {
        return names.split(NAMES_SPLITTER).toTypedArray()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CarNamesInput

        if (names != other.names) return false

        return true
    }

    override fun hashCode(): Int {
        return names.hashCode()
    }

    companion object {
        const val NAMES_SPLITTER = ","
    }
}
