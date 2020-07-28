package step3.racing.view

class ConsoleViewImpl : View {
    override fun input(message: String?): String? {
        if (message != null) {
            print(message)
        }
        return readLine()
    }

    override fun print(message: String) = println(message)
}
