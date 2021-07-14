import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 
 */
public class IntersectionOfTwoArrays {


    /**
     * Given two integer arrays nums1 and nums2, return an array of their intersection. 
     * Each element in the result must be unique and you may return the result in any order.
     * 
     * Using HashSet.
     * 
     * Runtime: 2 ms, faster than 95.11% of Java online submissions.
     * Memory Usage: 38.9 MB, less than 82.51% of Java online submissions.
     * 
     * 55 / 55 test cases passed.
     * Status: Accepted
     * Runtime: 2 ms
     * Memory Usage: 39 MB
     */
    static int[] intersection(int[] nums1, int[] nums2) {

        // **** initialization ****
        HashSet<Integer> hs = new HashSet<Integer>();
        List<Integer> ans   = new ArrayList<Integer>();

        // **** populate hash set - O(n) ****
        for (int i = 0; i < nums1.length; i++)
            hs.add(nums1[i]);

        // **** look for common values - O(m) ****
        for (int i = 0; i < nums2.length; i++) {

            // **** check if this is an intersection ****
            if (hs.contains(nums2[i])) {
    
                // **** add value to list ****
                ans.add(nums2[i]);

                // **** to avoid duplicates ****
                hs.remove(nums2[i]);
            }
        }

        // **** populate result with contents of list ****
        int[] result = new int[ans.size()];
        int j = 0;
        for (int r : ans)
            result[j++] = r;

        // **** return int[] result ****
        return result;
    }


    /**
     * Given two integer arrays nums1 and nums2, return an array of their intersection. 
     * Each element in the result must be unique and you may return the result in any order.
     * 
     * Sorting arrays.
     * 
     * Runtime: 5 ms, faster than 20.88% of Java online submissions.
     * Memory Usage: 38.9 MB, less than 91.27% of Java online submissions.
     * 
     * 55 / 55 test cases passed.
     * Status: Accepted
     * Runtime: 5 ms
     * Memory Usage: 38.9 MB
     */
    static int[] intersection0(int[] nums1, int[] nums2) {

        // **** initialization ****
        List<Integer> ans = new ArrayList<Integer>();

        // **** sort arrays - O(n * log(n)) ****
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        // **** traverse arrays looking for intersection(s) ****
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) i++;

            else if (nums1[i] == nums2[j]) {

                // **** check for duplicate values ****
                if (!ans.contains(nums1[i]))
                    ans.add(nums1[i]);

                // **** ****
                i++; j++;
            }
            
            else j++;
        }

        // **** populate result with the contents of the list ****
        int[] result = new int[ans.size()];
        i = 0;
        for (int r : ans)
            result[i++] = r;

        // **** return int[] result ****
        return result;
    }


    /**
     * Test scaffold.
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read `nums1` array ****
        int[] nums1 = Arrays.stream(br.readLine().trim().split(","))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        // **** read `nums2` array ****
        int[] nums2 = Arrays.stream(br.readLine().trim().split(","))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        // **** close buffered reader ****
        br.close();

        // ???? ????
        System.out.println("main <<< nums1: " + Arrays.toString(nums1));
        System.out.println("main <<< nums2: " + Arrays.toString(nums2));

        // **** call function of interest and display result ****
        System.out.println("main <<< intersection0: " + Arrays.toString(intersection0(nums1, nums2)));

        // **** call function of interest and display result ****
        System.out.println("main <<<  intersection: " + Arrays.toString(intersection(nums1, nums2)));
    }
}