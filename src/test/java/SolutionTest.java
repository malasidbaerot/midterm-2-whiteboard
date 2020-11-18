import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void testGetLeaf() {
        //         3
        //        / \
        //       9  20
        //      /    \
        //     1      8
        //           / \
        //          7   2
        TreeNode<Integer> root = new TreeNode<>(3);
        root.left = new TreeNode<>(9);
        root.right = new TreeNode<>(20);
        root.left.left = new TreeNode<>(1);
        root.right.right = new TreeNode<>(8);
        root.right.right.left = new TreeNode<>(7);
        root.right.right.right = new TreeNode<>(2);
        List<Integer> result = Solution.getLeafNodes(root);
        assertEquals(Arrays.asList(1, 7, 2), result);
    }

    @Test
    public void testIsSymmetrical() {
        List<symTestCase> testCases = getSymTestCases();
        for (int i = 0; i < testCases.size(); i++) {
            symTestCase testCase = testCases.get(i);
            boolean actual = Solution.isSymmetrical(testCase.root);
            assertEquals(String.format("case %d", i), testCase.isSymmetrical, actual);
        }
    }

    private List<symTestCase> getSymTestCases() {
        List<symTestCase> result = new ArrayList<>();

        result.add(new symTestCase(null, true));

        //       1
        //      / \
        //   null  null
        TreeNode<Integer> root = new TreeNode<>(1);
        result.add(new symTestCase(root, true));


        //       1
        //      / \
        //     2  null
        root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        result.add(new symTestCase(root, false));

        //       1
        //      / \
        //     2   3
        root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        result.add(new symTestCase(root, false));

        //       1
        //      / \
        //     2   2
        root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(2);
        result.add(new symTestCase(root, true));

        //         3
        //      /    \
        //     2      2
        //    / \    / \
        //   5   6  6   5
        root = new TreeNode<>(3);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(2);
        root.left.left = new TreeNode<>(5);
        root.left.right = new TreeNode<>(6);
        root.right.left = new TreeNode<>(6);
        root.right.right = new TreeNode<>(5);
        result.add(new symTestCase(root, true));

        //         3
        //      /    \
        //     2      4
        //    / \    / \
        //   5  6   6   5
        root = new TreeNode<>(3);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(4);
        root.left.left = new TreeNode<>(5);
        root.left.right = new TreeNode<>(6);
        root.right.left = new TreeNode<>(6);
        root.right.right = new TreeNode<>(5);
        result.add(new symTestCase(root, false));

        //         3
        //      /    \
        //     2      4
        //    / \    / \
        //   5  6   6   7
        root = new TreeNode<>(3);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(4);
        root.left.left = new TreeNode<>(5);
        root.left.right = new TreeNode<>(6);
        root.right.left = new TreeNode<>(6);
        root.right.right = new TreeNode<>(7);
        result.add(new symTestCase(root, false));

        //        8
        //      /   \
        //     5     5
        //    /       \
        //   9         9
        root = new TreeNode<>(8);
        root.left = new TreeNode<>(5);
        root.right = new TreeNode<>(5);
        root.left.left = new TreeNode<>(9);
        root.right.right = new TreeNode<>(9);
        result.add(new symTestCase(root, true));

        //        8
        //      /   \
        //     5     5
        //    / \
        //   9   8
        root = new TreeNode<>(8);
        root.left = new TreeNode<>(5);
        root.right = new TreeNode<>(5);
        root.left.left = new TreeNode<>(9);
        root.left.right = new TreeNode<>(8);
        result.add(new symTestCase(root, false));
        return result;
    }

    private class symTestCase {
        TreeNode<Integer> root;
        boolean isSymmetrical;

        public symTestCase(TreeNode<Integer> root, boolean isSymmetrical) {
            this.root = root;
            this.isSymmetrical = isSymmetrical;
        }
    }
}