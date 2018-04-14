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
		if(len<=1)
			return ;
		if(len==2){
			if(a[left]>a[right-1])
				swap(a, left, right-1);
			return ;
		}
		int pivot=findPivot(a, left, right);  //枢纽元
		//swap(a, left+len/2, right-1);
		int i=left,j=right-1;
		for(;;){
			while(a[++i]<pivot);
				//i++;
			while(a[--j]>pivot);
				//j--;
			if(i>=j)
				break;
			swap(a, i, j);		
		}
		swap(a, i, right-2);
		quickSort(a, left, i);
		quickSort(a, i, right);
	}
	/**
	 * 三值中数分割法选择枢纽元
	 * 首选对A[left],A[rignt-1],A[center]进行从小到大排序
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

}
