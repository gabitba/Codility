import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryGap {

    /*
    A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.

    For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps. The number 32 has binary representation 100000 and has no binary gaps.

    For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5. Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.
    */

    public int solution(int N) {
        if(N <= 0){
            return 0;
        }
        
        HashMap<Integer, Integer> binaryStream = new HashMap<Integer, Integer>();
        int number = N;
        int position = 0;

        while(number > 0){
            int remainder = number % 2;
            number /= 2;
            binaryStream.put(position, remainder);
            position++;
        }

        List<Integer> positionList = binaryStream.entrySet().stream().filter(item -> item.getValue() == 1).map(item -> item.getKey()).collect(Collectors.toList());
        if(positionList.size()> 1){
            int maxGap = 0;
            for(int i = 0; i < positionList.size() - 1; i++){
                int gap = Math.abs(positionList.get(i) - positionList.get(i + 1)) - 1;
                if(gap > maxGap){
                    maxGap = gap;
                }
            }
            return maxGap;
        }

        return 0;
    }
}