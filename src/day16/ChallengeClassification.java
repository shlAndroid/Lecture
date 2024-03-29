package day16;

class FindFrequency {
    int len;
    int nonRecursNum;
    int nonRecursElem;

    int[] wirelessFreq;

    int[] number;
    int[] freqCheck;

    public FindFrequency(int[] wF) {
        nonRecursNum = 0;
        nonRecursElem = 0;

        len = wF.length;

        wirelessFreq = new int[len];

        for(int i = 0; i < len; i++) {
            wirelessFreq[i] = wF[i];
        }
    }
    public void sorting() {
        int i, j, key;

        for(i = 1; i < len; i++) {
            key = wirelessFreq[i];

            for(j = i - 1; wirelessFreq[j] > key; j--) {
                wirelessFreq[j + 1] = wirelessFreq[j];
            }

            wirelessFreq[j + 1] = key;
        }
    }
    public void watchData() {
        for(int i = 0; i < len; i++) {
            System.out.printf("%8d", wirelessFreq[i]);
            if(i % 5 == 4) {
                System.out.println();
            }
        }
        System.out.println();
    }
    public void findNonDuplicateElem() {
        int i, j;

        for(i = 0; i < len; i++) {
            if(i == 0) {
                nonRecursNum++;
                continue;
            }

            for(j = 0; j < i; j++) {
                if(wirelessFreq[i] == wirelessFreq[j]) {
                    break;
                }
            }

            if(j == i)
                nonRecursNum++;
        }
    }
    public void watchNonRecursNum() {
        System.out.println(nonRecursNum);
    }
    public void postInit() {
        number = new int[nonRecursNum];
        freqCheck = new int[nonRecursNum];
    }
    public void setNonRecursNum() {
        int i, j;

        for(i = 0; i < len; i++) {
            for(j = 0; j < i; j++) {
                if(wirelessFreq[i] == wirelessFreq[j]) {
                    break;
                }
            }

            if(j == i) {
                number[nonRecursElem++] = wirelessFreq[i];
            }
        }
    }
    public void watchNumArr() {
        for(int i = 0; i < nonRecursNum; i++) {
            System.out.printf("%8d", number[i]);
            if(i % 5 == 4) {
                System.out.println();
            }
        }
        System.out.println();
    }
    public void setFreqArr() {
        int i, j;

        for(i = 0; i < len; i++) {
            for(j = 0; j < nonRecursElem; j++) {
                if(number[j] == wirelessFreq[i]) {
                    freqCheck[j]++;
                    break;
                }
            }
        }
    }
    public void watchFreqArr() {
        for(int i = 0; i < nonRecursNum; i++) {
            System.out.printf("%8d", freqCheck[i]);
            if(i % 5 == 4) {
                System.out.println();
            }
        }
        System.out.println();
    }
    public void pairSorting() {
        int i, j, key, key2;

        for(i = 1; i < nonRecursNum; i++) {
            key = freqCheck[i];
            key2 = number[i];

            for(j = i - 1; freqCheck[j] > key; j--) {
                freqCheck[j + 1] = freqCheck[j];
                number[j + 1] = number[j];
            }

            freqCheck[j + 1] = key;
            number[j + 1] = key2;
        }
    }
    public void watchPairSort() {
        int i;

        for(i = 0; i < nonRecursNum; i++) {
            System.out.println("number[" + i + "] = " +
                    number[i] + ", freqCheck[" + i +
                    "] = " + freqCheck[i]);

        }
    }
    public String toString() {
        return "";
    }
}

public class ChallengeClassification {
    /* 1,    5,    10,   10,   15,   150,  1500, 2300,
       2350, 2350, 2350, 2350, 2350, 2350, 2350, 2350,
       23423, 1231, 52352, 2352332, 13123, 34531, 2342,
       1231, 2342, 2342, 368, 4675, 47905, 45604, 4500,
       5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000

       위와 같은 데이터가 배열에 들어있다고 가정한다(무선 주파수임)
       여기서 가장 빈도수가 높은 주파수 대역을 2 개 추출하고
       몇 번 검출되었는지 확인하는 프로그램을 작성하시오. */
    public static void main(String[] args) {
        int[] wirelessFreq = {
                1, 5, 10, 10, 15, 150, 1500, 2300,
                2350, 2350, 2350, 2350, 2350, 2350, 2350, 2350,
                23423, 1231, 52352, 2352332, 13123, 34531, 2342,
                1231, 2342, 2342, 368, 4675, 47905, 45604, 4500,
                5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000,
                5000
        };

        FindFrequency ff = new FindFrequency(wirelessFreq);
        ff.watchData();
        ff.sorting();
        ff.watchData();
        ff.findNonDuplicateElem();
        ff.watchNonRecursNum();
        ff.postInit();
        ff.setNonRecursNum();
        ff.watchNumArr();
        ff.setFreqArr();
        ff.watchFreqArr();
        ff.pairSorting();
        ff.watchPairSort();
    }
}

/* 문제 8. 정수형 변수 2 개,
           4 byte 형 소수점 변수 1 개,
           8 byte 형 소수점 변수 1 개를 만들고 출력하시오.

   문제 9. 8 번 문제를 키보드 입력으로 처리해주세요 ~

   문제 10. 랜덤 숫자를 만드시오.

   문제 11. 랜덤 숫자 2 개를 작성하고
            이들간의 and, or, xor, not 을 계산하시오.

   문제 12. 랜덤 숫자를 만들고
            랜덤한 쉬프트 연산을 해보세요 ~

   문제 13. 2, 4, 6, 8, 10, ... , 120 ...
            100 번째까지 더한 숫자를 출력하시오.

   문제 14. 랜덤한 숫자를 2 개 입력받고
            대소 비교를 하세요 ~

   문제 15. 2 by 2 행렬의 뺄셈을 작성하세요 ~

   문제 16. Bank 클래스를 작성하시오.

   문제 17. 성적 관리 프로그램을 만들어보세요 ~

   문제 18. abstract 클래스와
            interface 의 차이점을 기술해보세요 ~
 */