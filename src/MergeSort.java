
public class MergeSort {

	static void partition(int[] nums, int low, int high, int mid) {

		int leftArraySize = mid - low + 1;
		int rightArraySize = high - mid;

		int[] leftArray = new int[leftArraySize];
		int[] rightArray = new int[rightArraySize];

		int leftArrayPointer = 0;
		int rightArrayPointer = 0;

		for (int i = low; i <= mid; i++) {
			leftArray[leftArrayPointer++] = nums[i];
		}

		for (int j = mid + 1; j <= high; j++) {
			rightArray[rightArrayPointer++] = nums[j];
		}

		leftArrayPointer = 0;
		rightArrayPointer = 0;
		int arrayPointer = low;
		while (leftArrayPointer < leftArraySize || rightArrayPointer < rightArraySize) {

			// if both sub arrays have values, compare current values
			if (leftArrayPointer < leftArraySize && rightArrayPointer < rightArraySize) {

				if (leftArray[leftArrayPointer] < rightArray[rightArrayPointer]) {
					nums[arrayPointer++] = leftArray[leftArrayPointer++];
				} else {
					nums[arrayPointer++] = rightArray[rightArrayPointer++];
				}
			}

			// if only one sub array has value left, copy over values from that
			// sub array
			else {
				if (leftArrayPointer < leftArraySize) {
					nums[arrayPointer++] = leftArray[leftArrayPointer++];
				}

				if (rightArrayPointer < rightArraySize) {
					nums[arrayPointer++] = rightArray[rightArrayPointer++];
				}
			}
		}
	}

	static void mergeSort(int[] nums, int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			mergeSort(nums, low, mid);
			mergeSort(nums, mid + 1, high);
			partition(nums, low, high, mid);
		}
	}

	public static void main(String[] args) {
		int[] x = { 4, 3, 2, 1 };
		mergeSort(x, 0, x.length - 1);
		print(x);
	}

	static void print(int[] x) {
		for (int i = 0; i < x.length; i++) {
			System.out.print(x[i] + " ");
		}
	}
}
