class WordFrequencyCounter {
    _wordFreqs : Object = _
    def WordFrequencyCounter(wfapp, dataStorage) {
        dataStorage.registerForWordEvent(incrementCount)
        wfapp.registerForEndEvent(printFreqs)
    }

    def incrementCount(word) {
        if(word in _wordFreqs) {
            _wordFreqs += 1
        }else {
            _wordFreqs = 1
        }
    }

    def printFreqs() {
        // TODO terminar
        wordFreqs = 
    }
}