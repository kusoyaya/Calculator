package calculator;

import java.util.regex.*;

public class Machine {
	private String user = "";
	private String answer = "0";
	boolean isOperatorClicked = true;
	
	
	public void appendUser(String appendment){
		user += appendment;
	}
	
	public String getUser(){
		return user;
	}
	
	public String getAnswer(){
		try{
			answer = cal(user);
		}catch(Exception e){
			answer = "Syntax error";
		}
		return answer;
	}
	
	public void clean(){
		user = "";
		answer = "0";
		isOperatorClicked=true;
	}
	
	public String cal(String s){
		s = calParentheses(s);
		s = calFunction(s);
		s = calTimesDevide(s);
		s = calPlusMinus(s);
		return s;
	}
	
	public String calParentheses(String s){
		Pattern pattern = Pattern.compile("\\((.*?)\\)");
		Matcher matcher = pattern.matcher(s);
		while(matcher.find()){
			s = matcher.replaceFirst(cal(matcher.group(1)));	
		}
		return s;
	}
	
	public String calFunction(String s){
		
		return s;
	}
	
	public String calTimesDevide(String s){
		Pattern pattern = Pattern.compile("[-]?[0-9]*\\.?[0-9]+[\\*\\/][-]?[0-9]*\\.?[0-9]+");
		Matcher matcher = pattern.matcher(s);
		double answer = 0;
		while(matcher.find()){
			System.out.println(matcher.group());
			String[] temp = matcher.group().split("\\*");
			if(temp.length == 2){
				answer = Double.parseDouble(temp[0]) * Double.parseDouble(temp[1]);
				s = matcher.replaceFirst(""+answer);
			}else{
				temp = matcher.group().split("\\/");
				answer = Double.parseDouble(temp[0]) / Double.parseDouble(temp[1]);
				s = matcher.replaceFirst(""+answer);
			}
			matcher.reset(s);
		}
		return s;
	}
	
	public String calPlusMinus(String s){
		Pattern pattern = Pattern.compile("[-]?[0-9]*\\.?[0-9]+[\\+\\-][-]?[0-9]*\\.?[0-9]+");
		Matcher matcher = pattern.matcher(s);
		double answer = 0;
		while(matcher.find()){
			System.out.println(matcher.group());
			String[] temp = matcher.group().split("\\+");
			if(temp.length ==2){
				answer = Double.parseDouble(temp[0]) + Double.parseDouble(temp[1]);
				if(answer*Double.parseDouble(temp[0])<0)
					s = matcher.replaceFirst("+"+answer);
				else
					s = matcher.replaceFirst(""+answer);
			}else{
				temp = matcher.group().split("\\-");
				if(temp.length ==2){
					answer = Double.parseDouble(temp[0]) - Double.parseDouble(temp[1]);
				}else if(temp.length ==4){
					answer = -1*Double.parseDouble(temp[1]) - -1*Double.parseDouble(temp[3]);
				}else{
					if(temp[0].equals(""))
						answer = -1*Double.parseDouble(temp[1]) - Double.parseDouble(temp[2]);
					else
						answer = Double.parseDouble(temp[0]) - -1*Double.parseDouble(temp[2]);
				}
				s = matcher.replaceFirst(""+answer);;
			}
			matcher.reset(s);
		}
		return s;
	}
}
