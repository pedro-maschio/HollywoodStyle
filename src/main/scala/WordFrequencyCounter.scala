import wfapp.WordFrequencyFramework
import dataStorage.DataStorage

object EndObject {
    def printFreqs() {
        // TODO ordenar
        for((word, freq) <- _wordFreqs) {
            println(word + "- " + freq)
        }
    }
}

class WordFrequencyCounter(wfapp: WordFrequencyFramework, dataStorage: DataStorage) {
    val _wordFreqs = collection.mutable.Map[String, Int]()

    dataStorage.registerForWordEvent(incrementCount)
    wfapp.registerForEndEvent(EndObject.printFreqs())

    def incrementCount(word: String) {
        if(_wordFreqs.contains(word)) {
            _wordFreqs[word]++
        } else {
            _wordFreqs.put(word, 1)
        }
    }


}