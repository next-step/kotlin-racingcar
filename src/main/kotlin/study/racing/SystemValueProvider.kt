package study.racing

object SystemValueProvider: ValueProvider<String?> {
    override fun getValue(): String? = readLine()
}