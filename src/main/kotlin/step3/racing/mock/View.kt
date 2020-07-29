package step3.racing.mock

interface View {
    fun input(message: String? = null): String?
    fun print(message: String = "")
}
