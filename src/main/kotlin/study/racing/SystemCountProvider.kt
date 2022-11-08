package study.racing

object SystemCountProvider: CountProvider {
    override fun getCount(): String? = readLine()
}