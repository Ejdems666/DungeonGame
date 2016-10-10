package Libs;

/**
 * Created by becva on 13.09.2016.
 */
public class NumericalSystemConverter {
    private int number;

    /**
     * @param number To convert
     */
    public NumericalSystemConverter(int number) {
        this.number = number;
    }

    public int getConvertedNumber(int systemFrom, int systemTo) {
        int oldNumber;
        if(systemFrom != 10) {
            oldNumber = getConvertedNumber(systemFrom,10);
        } else {
            oldNumber = number;
        }
        String convertedNumber = "";
        while (oldNumber > 0) {
            oldNumber = oldNumber / systemTo;
            convertedNumber += (oldNumber % systemTo);
        }
        return Integer.parseInt(convertedNumber);
    }
}
