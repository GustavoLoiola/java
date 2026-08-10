import java.util.*;

void main() {
    ArrayList<Integer> nums1 = new ArrayList<>();
    ArrayList<Integer> nums2 = new ArrayList<>();
    nums1.add(3);
    nums1.add(8);
    nums1.add(98);
    nums2.add(3);
    nums2.add(3);
    nums2.add(0);
    nums2.add(345);

    nums1.addAll(nums2);

   Collections.sort(nums1);

    System.out.println(nums1);
}
