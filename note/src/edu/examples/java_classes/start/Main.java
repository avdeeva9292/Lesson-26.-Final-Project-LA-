package edu.examples.java_classes.start;

import edu.examples.java_classes.controller.Controller;

public class Main {
	public static void main(String[] args) {
Controller controller = new Controller();
		
		String request;
		String response;
		
		request = "ADD\ntitle=Книга\nсоntent=Туманность Андромеды";
		response = controller.doAction(request);
		System.out.println(response);
		
		
		request = "UPDATE\nid=2\ntitle=Книга\ncontent=Туманность Андромеды\ndate=08.08.2023";
		response = controller.doAction(request);
		System.out.println(response);		
	
	request = "DISPLAY\nid=2\ntitle=Книга\ncontent=Туманность Андромеды\ndate=08.08.2023";
	response = controller.doAction(request);
	System.out.println(response);	

	request = "FINDBYCONTENT\ncontent=Туманность Андромеды";
	response = controller.doAction(request);
	System.out.println(response);	
	
	request = "FINDBYDATE\ndate=08.08.2023";
	response = controller.doAction(request);
	System.out.println(response);	
}
	}