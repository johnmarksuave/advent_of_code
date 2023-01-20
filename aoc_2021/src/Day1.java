import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day1 {
    public static void main(String[] args) throws Exception {
        //partA();
        partB();
    }

    public static void partB(){
        
        int depthIncreaseCount = 0;
        List<Integer> depthList = new ArrayList<>();
        loadDepthList(depthList);

        int lastDepthSum = 0;
        for(int i = 0; i < depthList.size() - 2; i++) {
            int depthSum = depthList.get(i) + depthList.get(i+1) + depthList.get(i+2);
            if(lastDepthSum != 0) {
                if(lastDepthSum < depthSum) {
                    depthIncreaseCount++;
                }
            }

            lastDepthSum = depthSum;
        }

        System.out.println("Depth increases: " + depthIncreaseCount);
    }

    public static void loadDepthList(List<Integer> depthList) {
		BufferedReader reader;
        try {
			reader = new BufferedReader(new FileReader("src/day1_input_a.txt"));
			String line = reader.readLine();

			while(line != null) {
                depthList.add(Integer.valueOf(line));
				line = reader.readLine();
			}

			reader.close();
		} catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void partA(){
        BufferedReader reader;
        int depthIncreaseCount = 0;

		try {
			reader = new BufferedReader(new FileReader("src/day1_input_a.txt"));
			String line = reader.readLine();

            int lastDepth = Integer.parseInt(line);


			while(line != null) {
				line = reader.readLine();

                if(line == null) {
                    break;
                }

                System.out.println(line);
                int newDepth = Integer.parseInt(line);

                if(newDepth > lastDepth) {
                    depthIncreaseCount++;
                }

                lastDepth = newDepth;
			}

			reader.close();
		} catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Depth increases: " + depthIncreaseCount);
    }
}
