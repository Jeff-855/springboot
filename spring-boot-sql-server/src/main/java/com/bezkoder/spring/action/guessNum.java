package com.bezkoder.spring.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.*;




public class guessNum {
	private static final String FILENAME = null;

	public List<Integer> generateAnswer(int retryCnt) throws IOException {
		List<Integer> al=new ArrayList<>();	
		final String FILENAME ="d:\\test.txt";
		File file = new File(FILENAME);
		FileWriter fw;
		if(retryCnt==1 && file.exists()){
			System.out.println("file exist");
			file.delete();
			file.createNewFile();
		}
		
		
		
		if (retryCnt==1) {
		   Random rd = new Random(); //產生Random物件
		  // List<Integer> al=new ArrayList<>();		
		  // TODO Auto-generated method stub
		    while(al.size()<3){ //總共10個數字
			    int n=rd.nextInt(10); //產生0~9數字
			    if(al.contains(n)) 
				    continue;     //重複的不加入
			    else
			    	al.add(n);
		   	   System.out.println(n);
		   	   
		     	try{
		     		
					fw = new FileWriter(file.getAbsoluteFile(), true);
					BufferedWriter bw = new BufferedWriter(fw);
										
		     		bw.write(String.valueOf(n));
		     		 
		     		bw.close();
		     		fw.close();
		   	    	
		   	    }
		   	    catch (IOException e){
		   	      System.out.println("An error occurred.");
		   	      e.printStackTrace();
		   	    }
		   	   
		   }
		}else {
			
				FileReader fr = new FileReader("d://test.txt");
				BufferedReader br = new BufferedReader(fr);
                String ansStr= br.readLine();
				System.out.println("ansStr is :"+ansStr);
				fr.close();  
		      
					
			    for (int i=0; i < ansStr.length(); i++){
	                   System.out.println("ansStrInt1:"+ Character.getNumericValue(ansStr.charAt(i)));
	                   al.add(Character.getNumericValue(ansStr.charAt(i)));
	            }
		}
        return al;
      }
	
	public int compareAnswer(List<Integer> al,int digital1,int digital2,int digital3) {
		int result = 0;
	
		List<Integer> digList = new ArrayList<>();
		digList.add(digital1);
		digList.add(digital2);
		digList.add(digital3);
		int ansi,ansj =0; 
		for(int i = 0; i< digList.size();i++) {
            System.out.print("digi:"+ digList.get(i)+" ");
                ansi = Integer.parseInt(digList.get(i).toString());
            
            for(int j = 0; j< al.size();j++) {
            	ansj = Integer.parseInt(al.get(j).toString());
            	 System.out.print("ansj:"+ al.get(j));
            	if (ansi==ansj) {
             	   if (i==j) {
             		   result = result +10;
             	   }else {
             		   result =result +1;
             	   }
             	   
                }
            }
            	
              
            }
        return result;
      }
}
