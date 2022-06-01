import java.util.ArrayList;
import java.util.List;

public class SILab2 {

    public static List<String> function(List<String> list) {
        if (list.size() <= 0) {   //1
            throw new IllegalArgumentException("List length should be greater than 0");//2
        }
        int n = list.size(); //3
        int rootOfN = (int) Math.sqrt(n); //4
        if (rootOfN * rootOfN != n) { //5
            throw new IllegalArgumentException("List length should be a perfect square");//6
        }
        List<String> numMines = new ArrayList<>(); //7
        //[0"0", 1"#", 2"0", 3"0", 4"0", 5"#", 6"#", 7"0", 8"#"]

        for (int i = 0; i < n; i++) { //8
            if (!list.get(i).equals("#")) { //9
                int num = 0; //10
                if ((i % rootOfN != 0 && list.get(i - 1).equals("#")) || (i % rootOfN != rootOfN - 1 && list.get(i + 1).equals("#"))) { //11
                    if ((i % rootOfN != 0 && list.get(i - 1).equals("#")) && (i % rootOfN != rootOfN - 1 && list.get(i + 1).equals("#"))) { //12
                        num += 2; //13
                    }
                    else { //14
                        num += 1; //15
                    }
                }
                if (i - rootOfN >= 0 && list.get(i - rootOfN).equals("#")) { //16
                    num++; //17
                }
                if (i + rootOfN < n && list.get(i + rootOfN).equals("#")) { //18
                    num++; //19
                }
                numMines.add(String.valueOf(num)); //20
            }
            else { //21
                numMines.add(list.get(i)); //22
            }
        }
        return numMines; //23
    }
}
