import scala.io.Source
import scala.util.matching.Regex
import wfapp.WordFrequencyFramework


trait WordEvent {
    def incrementCount(word: String)
}

object LoadObject {
    def load(pathToFile: String) {
        val filename = "t.txt"
        var d = pathToFile
        d = Source.fromFile(filename).getLines.mkString
        val pattern = "[\\W_]+".r
        d = (pattern.replaceAllIn(d, " ")).toLowerCase()
    }
}

object WorkObject {
    def produce_words(_data: String, _stopWordFilter: StopWordFilter) {
        // TODO terminar
        var data_str = _data.mkString(",")
        for(word <- data_str.split(' ')) {
            if(!_stopWordFilter.isStopWord(word)) {

            }
        }
    }
}

class DataStorage(wfapp: WordFrequencyFramework, stopWordFilter: StopWordFilter) {
    val _data : String
    var _stopWordFilter : StopWordFilter 
    val _wordEventHandlers : List[WordEvent]


    _stopWordFilter = stopWordFilter

    wfapp.registerForLoadEvent(LoadObject.load)
    wfapp.registerForDoWorkEvent(WorkObject.produce_words(_,_))
    

    def registerForWordEvent(handler: WordEvent) {
        _wordEventHandlers :+ handler
    }

}