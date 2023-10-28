package question_code;

import java.util.ArrayList;

public class QuestionGen {

	
	
	public static ArrayList<Question> Genquestion(){
		//temp until we get data bases working
		
		ArrayList<Question> qlist = new ArrayList<Question>();
		
		qlist.add(new triviaquestion("ans0","ans1","ans2(the right one)","ans3","temp question 0",2));
		qlist.add(new triviaquestion("ans0(the right one)","ans1","ans2","ans3","temp question 1",0));
		qlist.add(new triviaquestion("ans0","ans1","ans2","ans3(the right one)","temp question 2",3));
		qlist.add(new triviaquestion("ans0","ans1","ans2","ans3(the right one)","temp question 3",3));
		qlist.add(new triviaquestion("ans0","ans1(the right one)","ans2","ans3","temp question 4",1));
		qlist.add(new triviaquestion("ans0","ans1","ans2","ans3(the right one)","temp question 5",3));
		qlist.add(new triviaquestion("ans0","ans1","ans2","ans3(the right one)","temp question 6",3));
		qlist.add(new triviaquestion("ans0","ans1","ans2","ans3(the right one)","temp question 7",3));
		return qlist;
		
		
	}


}
