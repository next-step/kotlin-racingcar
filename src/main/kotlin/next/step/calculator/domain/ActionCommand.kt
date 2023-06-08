package next.step.calculator.domain

enum class ActionCommand(private val desc: String) {
    C("계산"), Q("종료");

    companion object {
        fun descAll(): String = values().joinToString(", ") { "${it.name}: ${it.desc}" }
    }

    fun isQuit(): Boolean {
        return this == Q
    }
}
