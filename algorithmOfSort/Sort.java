package sort;
public class Sort {
	/**
	 * Sort.java中包含常见的各种排序算法：
	 * quickSort()   快速排序
	 * 
	 * */
	
	/**  对数组中的两个函数进行交换，用得比较多
	 *   @param a 数组  
	 *   @param i 数组中要交换的下标之一
	 *   @param j 数组中要交换的下标之一
	 * */
	public  void swap(int a[],int i,int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
	
	/**  快速排序
	 *   @param a 数组  
	 *   @param left 数组起始下标（包含）
	 *   @param right 数组结束下标（不包含）
	 *   
	 * */
	public void quickSort(int[] a ,int left,int right){
		int len=right-left;
		if(len<=1)  //如果只有一个元素，直接返回
			return ;
		if(len==2){   //如果有两个元素则比较交换之后返回
			if(a[left]>a[right-1])
				swap(a, left, right-1);
			return ;
		}
		
		//只有元素个数在3个以上时才进行quickSort
		int pivot=findPivot(a, left, right);  //枢纽元
		int i=left,j=right-1;
		for(;;){
			while(a[++i]<pivot);
			while(a[--j]>pivot);
			if(i>=j)  //如果i>=j,说明已经遍历完
				break;
			swap(a, i, j);		
		}
		swap(a, i, right-2);   //把枢纽元和i所在位置的元素交换
		
		//分别对i的左部和右部元素进行quickSort
		quickSort(a, left, i);
		quickSort(a, i, right);
	}
	/**
	 * 三值中数分割法选择枢纽元
	 * 首选对A[left],A[right-1],A[center]进行从小到大排序
	 * 经过该操作后，三元素的最大者被放到了A[right-1]
	 * 最小者被放到了A[left],A[center]中的元素大小居中
	 * 这样就可以作为枢纽元。由于A[right-1]大于枢纽元
	 * 我们可以把枢纽元放到A[right-2],并在分割阶段将左右的遍历索引i和j分别置为left,right-2.
	 * 此时A[left]比枢纽元小，不用担心j越界；同时枢纽元存储在A[right-2],将为i提供一个警戒标记
	 */
	/**三值中数分割法
	 * @param a 数组  
	 * @param left 数组起始下标（包含）
	 * @param right 数组结束下标（不包含）
	 * */
	public int findPivot(int[] a,int left,int right){
		//选出枢纽元并把枢纽元置于right-2处
		int center=left+(right-left)/2;
		if(a[center]<a[left])
			swap(a, left, center);
		if(a[center]>a[right-1])
			swap(a, center, right-1);
		if(a[center]<a[left])
			swap(a, center, left);
		swap(a, center, right-2);
		return a[right-2];
	}
	
    /**
     * 堆排序
     * @param a  要排序的数组
     * */
	public void heapSort(int[] a){
		
	}

}
