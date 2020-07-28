package step3.racing.view

interface View {
    fun input(message: String? = null): String?
    fun print(message: String = "")
    fun renderView()
}
