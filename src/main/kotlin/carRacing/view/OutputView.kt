package carRacing.view

class OutputView {
    fun printMessageInBox(message: String) {
        println("====================================")
        println(message)
        println("====================================")
    }

    fun printMessagesInBox(vararg messages: String) {
        println("====================================")
        printMessages(*messages)
        println("====================================")
    }

    fun printMessages(vararg messages: String) {
        for (message in messages) {
            println(message)
        }

        println()
    }
}
