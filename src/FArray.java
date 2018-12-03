public class FArray {

	long maxLength=100000;
	int blockSize=1000;
	private char[][] myArray;
	/**
	 * Constructor: 
	 * @param maxLength maximal VectorLength
	 * @param blockSize reserves memory in blocks of blockSize
	 */
	FArray(){
		myArray = new char[(int)(maxLength/(long)(blockSize))][];
	}
	
	public void resize(long length)
	{
		char newArray[][] = new char[(int)(length/(long)(blockSize))][];
		for (int t=0; t<maxLength/blockSize;t++) {
			newArray[t] = myArray[t];
		}
		myArray = newArray;
		maxLength = length;
	}
	/**
	 * setValue is the function to store the value in the array
	 * similar to vector[index] = value
	 * @param index
	 * @param value
	 */
	public void setValue(int index, char value)
	{
		int x = index%blockSize;
		int y = index/blockSize;
		
		if (index<0) {
			System.out.println("Index negativ!");
			return;
		}
		if (index>=maxLength) {
			resize(index*2);
		}
		if (myArray[y] == null){
			myArray[y] = new char[blockSize];
		}
		myArray[y][x] = value;

	}
	/**
	 * getValue reads out the value from the array
	 * @param index : index of the array
	 * @return      : returns the value 
	 */
	public char getValue(int index)
	{
		if (index<0 || index>maxLength) {
			return 0;
		}
		int x = index%blockSize;
		int y = index/blockSize;

		if (myArray[y] == null){
			return 0;
		}
		else{
			return myArray[y][x];
		}
	}

}