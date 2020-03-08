package number.algorithms;

import java.io.IOException;
import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import number.data.DataManager;
import number.models.Draw;
import number.models.Numbers;
import number.models.WinningNumber;
import number.models.WinningNumbers;

public class BuildRelation {
    private static Logger logger = LoggerFactory.getLogger(DataManager.class);
    private Numbers numbers;
    private LinkedList<int[]> list = new LinkedList<>();

    private void insertList(int[] array, WinningNumber number) {
        if(number.getIsSpecial()) {
            array[5] = number.getNumber();
        } else {
            for(int i = 0; i < 5; ++i) {
                if(array[i] == 0) {
                    array[i] = number.getNumber();
                    break;
                }
            }
        }
    }

    public BuildRelation(Numbers numbers) throws IOException {
        if (numbers == null) {
            numbers = DataManager.getData();
        }
        this.numbers = numbers;
        for (Draw draw : this.numbers.getPreviousDraws()) {
            WinningNumbers winningNumbers = draw.getWinningNumbers();
            int[] array = new int[6];
            insertList(array, winningNumbers.getZero());
            insertList(array, winningNumbers.getOne());
            insertList(array, winningNumbers.getTwo());
            insertList(array, winningNumbers.getThree());
            insertList(array, winningNumbers.getFour());
            insertList(array, winningNumbers.getFive());
            list.add(array);
        }
    }

    public LinkedList<int[]> getList() {
        return this.list;
    }
}