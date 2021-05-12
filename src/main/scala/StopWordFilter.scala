class StopWordFilter {
    _stopWords : List[Any] = _

    def StopWordFilter(wfapp) {
        wfapp.registerForLoadEvent(load)
    }

    def load(ignore) {
        val filename = "stop_words.txt"
        _stopWords = Source.fromFile(filename).getLines.toList
        // juntar a list de stopword com a, b, c, d, e ...
    }
    
    def isStopWord(word) {
        return _stopWords.contains(word)
    }
}