public class ScoreAnalyzer {

    public static void main(String[] args) {
        int[] scores = {72, 85, 91, 60, 85, 78, 95, 60};
        System.out.println("原数组为：" );
        for (int i=0;i< scores.length;i++) {
            System.out.print(scores[i] + " ");
        }
        System.out.println();

        int max = findMax(scores);
        if (max >= 0)
            System.out.println("最高分：" + max);

        contains(scores, 91);

        int[] sc = sortDescending(scores);
        if (scores == null || scores.length == 0)
            System.out.println("数组不能为空");
        else {
            System.out.print("降序结果：");
            for (int i = 0; i < sc.length; i++) {
                System.out.print(sc[i] + " ");
            }
            System.out.println();
        }

        if (scores == null || scores.length == 0) {
            System.out.println("数组不能为空");
        } else {
            System.out.printf("平均分：%.2f\n", average(scores));
        }


        System.out.print("去重后的分数：");
        int[] result = deduplicate(scores);
        if (scores == null || scores.length == 0) {
            System.out.println("数组不能为空");
        } else {
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
        }

        if (scores == null || scores.length == 0) {
            System.out.println("数组不能为空");
        } else if (average(scores, 3, 5) == -2) {
            System.out.println("下标范围非法");
        } else {
            System.out.printf("下标%d到下标%d之间的平均分：%.2f\n", 3, 5, average(scores, 3, 5));
        }

    }

    public static int findMax(int[] scores) {
        if(scores==null||scores.length==0) {
            System.out.println("数组不能为空");
            return -1;
        }
        int max = scores[0];
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
            }
        }
        return max;
    }

    public static boolean contains(int[] scores, int target) {
        if(scores==null||scores.length==0) {
            System.out.println("数组不能为空");
            return false;
        }
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == target) {
                System.out.printf("找到目标分数%d\n", target);
                return true;
            }
        }
        System.out.println("没有找到目标分数");
        return false;
    }

    public static int[] sortDescending(int[] scores) {
        if(scores==null||scores.length==0) {
            System.out.println("数组不能为空");
            return null;
        }
        int[] sort = scores.clone();
        int temp;
        for (int i = 0; i < scores.length; i++) {
            for (int n = 0; n < scores.length - i; n++) {
                if (n >= scores.length - 1) {
                    continue;
                } else if (sort[n] < sort[n + 1]) {
                    temp = sort[n + 1];
                    sort[n + 1] = sort[n];
                    sort[n] = temp;
                }
            }
        }
        return sort;
    }

    public static float average(int[] scores) {
        if (scores == null || scores.length == 0) {
            return -1;
        }
        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }
        return (float) (sum * (1.0) / scores.length);
    }

    public static int[] deduplicate(int[] scores) {
        if(scores==null||scores.length==0){
            return null;
        }
        int[] temp = new int[scores.length];
        int count = 0;//放入的唯一值的个数
        boolean exists = false;
        for (int i = 0; i < scores.length; i++) {
            for (int n = 0; n < count; n++) {
                if (temp[n] == scores[i]) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                temp[count] = scores[i];
                count++;
            }
            exists = false;
        }
        int[] result = new int[count];
        //Java内置的数组拷贝方法，把temp的前count个元素复制到result里
        System.arraycopy(temp, 0, result, 0, count);
        return result;
    }

    public static float average(int[] scores, int start, int end) {
        if (scores == null || scores.length == 0) {
            return -1;
        } else if (start < 0 || end > scores.length || start >= end) {
            return -2;
        } else {
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += scores[i];
            }
            return (float) ((sum *1.0)/ (end - start));
        }
    }
}



