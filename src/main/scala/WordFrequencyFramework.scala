class WordFrequencyFramework() {
    var _loadEventHandlers : List[Any] = _
    var _doworkEventHandlers : List[Any] = _
    var _endEventHandlers : List[Any] = _

    def registerForLoadEvent(handler: Any): Unit = {
        _loadEventHandlers = _loadEventHandlers :+ handler
    }

    def registerForDoWorkEvent(handler: Any): Unit = {
        _doworkEventHandlers = _doworkEventHandlers :+ handler
    }

    def registerForEndEvent(handler: Any): Unit = {
        _endEventHandlers = _endEventHandlers :+ handler
    }

    def run(pathToFile: String): Unit = {
        // TODO verificar lista de funções
        _loadEventHandlers.map(handler => handler(pathToFile))
        _doworkEventHandlers.map(handler => handler())
        _endEventHandlers.map(handler => handler())
    }
}

// object Hello {
//     def main(args: Array[String]) = {
//         println("Hello, world")
//     }
// }