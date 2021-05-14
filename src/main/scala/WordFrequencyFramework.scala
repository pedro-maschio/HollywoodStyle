package wfapp 

trait LoadEvent {
    def load(filename: String)
}

trait DoWorkEvent {
    def produce_words()
}

trait EndWorkEvent {
    def printFreqs()
}

class WordFrequencyFramework() {
    var _loadEventHandlers : List[LoadEvent] = _
    var _doworkEventHandlers : List[DoWorkEvent] = _
    var _endEventHandlers : List[Any] = _

    def registerForLoadEvent(handler: LoadEvent): Unit = {
        _loadEventHandlers = _loadEventHandlers :+ handler
    }

    def registerForDoWorkEvent(handler: DoWorkEvent): Unit = {
        _doworkEventHandlers = _doworkEventHandlers :+ handler
    }

    def registerForEndEvent(handler: EndWorkEvent): Unit = {
        _endEventHandlers = _endEventHandlers :+ handler
    }

    def run(pathToFile: String): Unit = {
        // TODO verificar lista de funções

        for(elemento <- _loadEventHandlers) {
            elemento.load(pathToFile)
        }
        for(elemento <- _doworkEventHandlers) {
            elemento.produce_words()
        }
        for(elemento <- _endEventHandlers) {
        
        }

        // _loadEventHandlers.map(handler => handler(pathToFile))
        // _doworkEventHandlers.map(handler => handler())
        // _endEventHandlers.map(handler => handler())
    }
}

// object Hello {
//     def main(args: Array[String]) = {
//         println("Hello, world")
//     }
// }