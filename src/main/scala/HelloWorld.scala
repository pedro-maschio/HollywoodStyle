class WordFrequencyFramework() {
    var _load_event_handlers : List[Any] = _
    var _dowork_event_handlers : List[Any] = _
    var _end_event_handlers : List[Any] = _

    def registerForLoadEvent(handler: Any): Unit = {
        _load_event_handlers = _load_event_handlers :+ handler
    }

    def registerForDoWorkEvent(handler: Any): Unit = {
        _dowork_event_handlers = _dowork_event_handlers :+ handler
    }

    def registerForEndEvent(handler: Any): Unit = {
        _end_event_handlers = _end_event_handlers :+ handler
    }

    def run(pathToFile: String): Unit = {
        _load_event_handlers.map(handler => handler(pathToFile))
        _dowork_event_handlers.map(handler => handler())
        _end_event_handlers.map(handler => handler())
    }
}

// object Hello {
//     def main(args: Array[String]) = {
//         println("Hello, world")
//     }
// }