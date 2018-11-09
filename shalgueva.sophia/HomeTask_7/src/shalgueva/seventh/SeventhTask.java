package shalgueva.seventh;

public class SeventhTask {

	public static void main(String[] args) {
		try {
			ByteStream byteStr = new ByteStream("D:/Data/Java_1/HomeTask_7/src/shalgueva/seventh/byte.txt");
			byteStr.readAndWrite();
			
			SymbolStream symStr = new SymbolStream("D:/Data/Java_1/HomeTask_7/src/shalgueva/seventh/symbol.txt");
			symStr.readAndWrite();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
