package filfile_project_3;

/**
 * Comparator interface implementation on DictionaryItem
 * @author Mariamawit
 */
public class DictionaryItem implements Comparable<DictionaryItem> {
    //consists of two elements: a String and an integer to track number of occurrences
    private String word;
    private int numOccurence;

    /**
     * create constructors for words
     * @param word
     */
    public DictionaryItem(String word) {
        this.word = word;
        this.numOccurence = 1;
    }

    DictionaryItem() {
        this.word = "";
        this.numOccurence = 0;
    }

    //accessor and mutator methods for the string and number of ocuurences
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getNumOccurence() {
        return numOccurence;
    }

    public void setNumOccurence(int numOccurence) {
        this.numOccurence = numOccurence;
    }

    /**
     * overrides the toString method
     * @return  word: and numberOccurnece
     */
    @Override
    public String toString() {
        return this.word + "(" + this.numOccurence + ")";
    }

    /**
     * the equals method based on the String value of a the DictionaryItem
     * @param obj
     * @return by comparing two words
     */
    @Override
    public boolean equals(Object obj) {
        //comparing an object to itself?
        if (this == obj) {
            return true;
        }
        //comparing an object to nothing?
        if (obj == null) {
            return false;
        }
        //comparing two different types of objects?
        if (getClass() != obj.getClass()) {
            return false;
        }
        //comparing two words :
        DictionaryItem other = (DictionaryItem) obj;
        return (this.word.equals(other.word));
    }

    /**
     * the compareTo method is based on the String value of the word
     * @param o object
     * @returns either 0,1,or,-1 by comparing words
     */
    @Override
    public int compareTo(DictionaryItem o) {
        String thisWord = this.word;
        String anotherWord = o.word;
        int result = thisWord.compareTo(anotherWord);
        if (result == 0) {
            return 0;
        } 
        else if (result > 0) {
            return 1;
        } 
        else {
            return -1;
        }
    }

}
