import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ProblemSet10 {

    public static void main(String[] args) {

    }

    public String[] fizzBuzz(int start, int end) {
        if (start < end) {
            int counter = start;
            ArrayList<String> temp = new ArrayList<>();

            while (counter < end) {
                if (counter % 3 == 0) {
                    if (counter % 5 == 0) {
                        temp.add("FizzBuzz");
                    } else {
                        temp.add("Fizz");
                    }
                } else if (counter % 5 == 0) {
                    temp.add("Buzz");
                } else {
                    temp.add(String.valueOf(counter));
                }
                counter++;
            }

            String[] returnList = new String[temp.size()];
            int count = 0;

            for (String s : temp) {
                returnList[count] = s;
                count++;
            }
            return returnList;
        }
        return null;
    }

    public int maxSpan(int[] numbers) {
        if (numbers != null) {
            switch (numbers.length) {
                case 0:
                case 1:
                    return numbers.length;
                default:
                    break;
            }

            int span = 1;
            for (int i = 0; i < numbers.length; i++) {
                int num = numbers[i];

                for (int z = numbers.length - 1; z > i; z--) {
                    if (numbers[z] == num && span < (z - i + 1)) {
                        span = z - i + 1;
                    }
                }
            }
            return span;
        }
        return -1;
    }

    public int[] fix34(int[] numbers) {
        if (numbers != null) {
            ArrayList<Integer> fours = new ArrayList<>();
            ArrayList<Integer> threes = new ArrayList<>();
            ArrayList<Integer> nums = new ArrayList<>();

            for (int i = 0; i < numbers.length; i++) {
                nums.add(numbers[i]);
                if (numbers[i] == 3) {
                    threes.add(i);
                } else if (numbers[i] == 4) {
                    fours.add(i);
                }
            }

            if (fours.size() == threes.size() && threes.get(0) < fours.get(0)) {
                boolean checkA = true;

                for (int i = 0; i < nums.size() - 1; i++) {
                    if (nums.get(i) == 3 && nums.get(i + 1) == 3) {
                        checkA = false;
                    }
                }

                if (checkA) {
                    for (int i = 0; i < fours.size(); i++) {
                        nums.remove(Integer.valueOf(4));
                    }
                    for (int i = 0; i < threes.size(); i++) {
                        nums.remove(Integer.valueOf(3));
                    }
                    for (int i = 0; i < threes.size(); i++) {
                        nums.add(threes.get(i), 3);
                        nums.add(threes.get(i) + 1, 4);
                    }

                    int[] returnList = new int[nums.size()];

                    for (int i = 0; i < nums.size(); i++) {
                        returnList[i] = nums.get(i);
                    }

                    return returnList;
                }
            }
        }
        return null;
    }

    public int[] fix45(int[] numbers) {
        if (numbers != null) {
            ArrayList<Integer> fours = new ArrayList<>();
            ArrayList<Integer> fives = new ArrayList<>();
            ArrayList<Integer> nums = new ArrayList<>();

            for (int i = 0; i < numbers.length; i++) {
                nums.add(numbers[i]);
                if (numbers[i] == 5) {
                    fives.add(i);
                } else if (numbers[i] == 4) {
                    fours.add(i);
                }
            }

            if (fours.size() == fives.size()) {
                boolean checkA = true;

                for (int i = 0; i < nums.size() - 1; i++) {
                    if (nums.get(i) == 4 && nums.get(i + 1) == 4) {
                        checkA = false;
                    }
                }

                if (checkA) {
                    for (int i = 0; i < fours.size(); i++) {
                        nums.remove(Integer.valueOf(4));
                    }
                    for (int i = 0; i < fives.size(); i++) {
                        nums.remove(Integer.valueOf(5));
                    }
                    for (int i = 0; i < fives.size(); i++) {
                        nums.add(fours.get(i), 4);
                        nums.add(fours.get(i) + 1, 5);
                    }

                    int[] returnList = new int[nums.size()];

                    for (int i = 0; i < nums.size(); i++) {
                        returnList[i] = nums.get(i);
                    }

                    return returnList;
                }
            }
        }
        return null;
    }

    public boolean canBalance(int[] numbers) {
        if (numbers != null && numbers.length > 0) {
            for (int i = 0; i < numbers.length; i++) {
                int[] start = Arrays.copyOfRange(numbers, 0, i+1);
                int[] end = Arrays.copyOfRange(numbers, i+1, numbers.length+1);

                int startSum = 0;
                int endSum = 0;

                for (int n : start) {
                    startSum += n;
                }

                for (int n : end) {
                    endSum += n;
                }

                if (startSum == endSum) return true;
            }
        }
        return false;
    }

    public boolean linearIn(int[] outer, int[] inner) {
        if (outer != null && inner != null && outer.length > 0 && inner.length > 0) {
            for (int i = 0; i < inner.length - 1; i++) {
                if (inner[i] > inner[i + 1])
                    return false;
            }
            for (int i = 0; i < outer.length - 1; i++) {
                if (outer[i] > outer[i + 1]) {
                    return false;
                }
            }

            int check = 0;

           for (int i = 0; i < inner.length; i++) {
               for (int z : outer) {
                   if (z == inner[i]) {
                       check++;
                       break;
                   }
               }
           }

            if (check < inner.length) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int[] squareUp(int n) {
        if (n >= 0) {
            if (n == 0) {
                int[] output = new int[0];
                return output;
            }

            int[] output = new int[n * n];
            int counter = 0;

            for (int i = n; i > 0; i--) {
                int sub = i - 1;

                for (int z = 0; z < n; z++) {
                    if (sub > 0) {
                        output[counter] = 0;
                    } else {
                        output[counter] = n - z;
                    }
                    counter++;
                    sub--;
                }
            }
            return output;
        }
        return null;
    }

    public int[] seriesUp(int n) {
        if (n >= 0) {
            if (n == 0) {
                int[] output = new int[0];
                return output;
            }

            ArrayList<Integer> array = new ArrayList<>();

            int length = 1;

            for (int i = 0; i < n; i++) {
                int count = 1;

                for (int z = 0; z < length; z++) {
                    array.add(count);
                    count++;
                }
                length++;
            }

            int[] output = new int[array.size()];
            int counter = 0;

            for (int i : array) {
                output[counter] = i;
                counter++;
            }

            return output;
        }
        return null;
    }

    public int maxMirror(int[] numbers) {
        if (numbers != null) {
            int l1 = numbers.length;
            int l2 = l1;

            int[][] LCSuff = new int[l1 + 1][l2 + 1];
            int result = 0;

            for (int i = 0; i <= l1; i++) {
                for (int z = 0; z <= l2; z++) {
                    if (i == 0 || z == 0) {
                        LCSuff[i][z] = 0;
                    } else if (numbers[i - 1] == numbers[l2 - z]) {
                        LCSuff[i][z] = LCSuff[i-1][z-1] + 1;
                        result = Math.max(result, LCSuff[i][z]);
                    } else {
                        LCSuff[i][z] = 0;
                    }
                }
            }
            return result;
        }
        return -1;
    }

    public int countClumps(int[] numbers) {
        if (numbers != null) {
            int current = numbers[0];
            int past1 = current;
            int past2 = past1;
            int count = 0;

            if (numbers[0] == numbers[1]) count++;
            for (int i = 0; i < numbers.length; i++) {
                past2 = past1;
                past1 = current;
                current = numbers[i];

                if (current == past1 && past1 != past2) {
                    count++;
                }
            }
            return count;
        }
        return -1;
    }
}
