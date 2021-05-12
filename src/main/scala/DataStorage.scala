import scala.io.Source
import scala.util.matching.Regex

class DataStorage {
    _data : String = _
    _stopWordFilter : String = _
    _wordEventHandlers : List[Any] = _

    def DataStorage(wfapp, stopWordFilter) {
        this._stopWordFilter = stopWordFilter
        wfapp.registerForLoadEvent()
        wfapp.registerForDoWorkEvent()
    }

    def load() {
        val filename = "t.txt"
        _data = Source.fromFile(filename).getLines.mkString
        val pattern = "[\W_]+".r
        _data = (pattern replaceAllIn(_data, ' ')).toLowerCase()
    }

    def produce_words() {
        // TODO terminar
        data_str = _data.mkString(",")
        for word in data_str.split() {
            if(!_stopWordFilter.isStopWord(w)) {
            }
        }
    }

    def registerForWordEvent(handler) {
        _wordEventHandlers :+ handler
    }

}