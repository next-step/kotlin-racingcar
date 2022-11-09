package racingcar.etc

data class StringAsNumber(private val text: String) : Number() {

    override fun toByte(): Byte {
        TODO("Not yet implemented")
    }

    override fun toChar(): Char {
        TODO("Not yet implemented")
    }

    override fun toDouble(): Double {
        TODO("Not yet implemented")
    }

    override fun toFloat(): Float {
        TODO("Not yet implemented")
    }

    override fun toInt(): Int {
        return requireNotNull(text.toIntOrNull()) { "숫자가 아닌 값을 입력할 수 없습니다." }
    }

    override fun toLong(): Long {
        TODO("Not yet implemented")
    }

    override fun toShort(): Short {
        TODO("Not yet implemented")
    }
}
