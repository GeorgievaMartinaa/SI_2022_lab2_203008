# SI_2022_lab2_203008

Мартина Георгиева 203008

1. Код
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


2.Control Flow Graph
![lab2SI](https://user-images.githubusercontent.com/100592896/170270320-6a8869ef-df29-4118-ad20-babd699793e2.png)

3.Цикломатската комплексност
Цикломатската комплексност на дадениот код е 9. Тоа го пресметуваме како бројот на предикати +1. Во кодот има 8 предикати +1=9. Исто така и ако ги изброиме регионите ке видиме дека има 9 региони во CFG

4.Тест случаи според критериумот Every statement
Потребни ни се 3 тест случаи:
- Празна листа: lista[]
- Листа со пример 3 аргументи: list["0","#","0"]
- Листа со пример 9 аргументи: list["0", "#", "0", "0", "0", "#", "#", "0", "#"]
Со првиот тест случај (празна листа) ги исминуваме линиите 1 и 2
Со вториот тест случај ги исминуваме линиите 1,3,4,5,6
Со третиот тест случај ги изминуваме линиите 1,3,4,5,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23

5.Тест случаи според критериумот Every path
