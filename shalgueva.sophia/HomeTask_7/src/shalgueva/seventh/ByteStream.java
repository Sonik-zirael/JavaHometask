package shalgueva.seventh;

import java.io.*;
import java.util.ArrayList;

public class ByteStream {
	private String fileName_ = "";
	public ArrayList<Container> words_ = new ArrayList<Container>();
	
	ByteStream(String fileName) {
		fileName_ = fileName;
	}
	
	public void readAndWrite() {
		try (FileInputStream inStream = new FileInputStream(fileName_);
			      FileOutputStream outStream = new FileOutputStream("outByte.txt")) {
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
				outStream.write(s.value_.getBytes());
				outStream.write(Integer.toString(s.amount_).getBytes());
				outStream.write(" ".getBytes());
			  }
		      outStream.write(Integer.toString(counter).getBytes());
		    } catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


