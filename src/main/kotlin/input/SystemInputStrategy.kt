package input

class SystemInputStrategy : InputStrategy {
    override fun enter(): String? {
        return readLine()
    }
}
