import wfapp.WordFrequencyFramework

class StopWordFilter {
    val _stopWords : List[String] 

    def StopWordFilter(wfapp: WordFrequencyFramework) {
        wfapp.registerForLoadEvent(load)
    }

    def load(ignore: String) {
        val filename = "stop_words.txt"
        _stopWords = Source.fromFile(filename).getLines.toList
        // juntar a list de stopword com a, b, c, d, e ...
    }
    
    def isStopWord(word: String): Boolean = {
        _stopWords.contains(word)
        
    }
}