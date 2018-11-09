package shalgueva.seventh;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SymbolStream {
	private String fileName_ = "";
	public ArrayList<Container> words_ = new ArrayList<Container>();
	
	public SymbolStream(String fileName) {
		fileName_ = fileName;
	}
	
	public void readAndWrite() {
		try (FileReader inStream = new FileReader(fileName_);
				FileWriter outStream = new FileWriter("outSym.txt")) {
			String buffer = "";
			int tmp = 0;
			while ((tmp = inStream.read()) != -1) {
				buffer += (char)tmp;
			}
			String[] textInArray = buffer.split("\\s");
			int counter = 0;
			for (String word : textInArray)
		      {
		        if (Utills.isKeyWord(word))
		        {
		          counter++;
		          if (words_.isEmpty()) {
		        	  Container temp = new Container(word, 1);
	        		  words_.add(temp);
		          } else {
		        	  boolean flag = false;
		        	  for (Container s: words_) {
			        	  if (s.value_.equals(word)) {
			        		  s.amount_ ++;
			        		  flag = true;
			        		  break;
			        	  } 
			          }
		        	  if (!flag) {
		        		  Container temp = new Container(word, 1);
			        	  words_.add(temp);
			        	}
		        	}
		        }
		      }
			for (Container s: words_) {
				outStream.write(s.value_);
				outStream.write(Integer.toString(s.amount_));
				outStream.write(" ");
			}
		      outStream.write(Integer.toString(counter));
		    } catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

}
